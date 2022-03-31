package com.ru.br.wishlist.preferences.security.provider


import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import java.security.Key
import java.util.*
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

@Service
class JwtProviderImpl @Autowired constructor(
    private val env: Environment
) : JwtProvider {

    private val secretKey: String = getSecretKey()
    private val algorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
    private val apiKey: ByteArray = DatatypeConverter.parseBase64Binary(secretKey)
    private val key: Key = SecretKeySpec(apiKey, algorithm.jcaName)

    override fun generateToken(username: String): String {
        val now = Date()
        val expiryDate = Date(now.time + getJwtTokenLive())
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(expiryDate)
            .signWith(key, algorithm)
            .compact()
    }

    override fun validateToken(token: String): Boolean {
        val jwtParser =  Jwts.parserBuilder().setSigningKey(secretKey)
        return try {
            jwtParser.build().parseClaimsJws(token)
            true
        } catch (ex: Exception) {
            false
        }
    }

    override fun getUserIdFromToken(token: String): Long {
        val jwtParser =  Jwts.parserBuilder().setSigningKey(secretKey)
        val claims = jwtParser.build().parseClaimsJws(token).body
        return claims.subject.toLong()
    }

    override fun getUsernameFromToken(token: String): String {
        val jwtParser =  Jwts.parserBuilder().setSigningKey(secretKey)
        val claims = jwtParser.build().parseClaimsJws(token).body
        return claims.subject
    }

    private fun getJwtTokenLive() : Int {
        return (env.getProperty("jwt.expiration"))?.toInt()!!
    }

    private fun getSecretKey() : String {
        return (env.getProperty("jwt.secret"))!!
    }
}