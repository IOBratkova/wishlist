import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	kotlin("plugin.jpa") version "1.6.10"
}

group = "com.ru.br"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

val jwtVersion by extra("0.11.2")

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.6.5")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.5")
	implementation("org.springframework.boot:spring-boot-starter-jdbc:2.6.5")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client:2.6.5")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server:2.6.5")
	implementation("org.springframework.boot:spring-boot-starter-security:2.6.5")
	implementation("org.springframework.boot:spring-boot-starter-web:2.6.5")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.2")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.liquibase:liquibase-core:4.9.0")
	compileOnly("org.projectlombok:lombok:1.18.22")
	runtimeOnly("org.postgresql:postgresql:42.3.3")
	annotationProcessor("org.projectlombok:lombok:1.18.22")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.5")
	testImplementation("org.springframework.security:spring-security-test:5.6.2")
	implementation("io.jsonwebtoken", "jjwt-api", jwtVersion)
	runtimeOnly("io.jsonwebtoken", "jjwt-impl", jwtVersion)
	runtimeOnly("io.jsonwebtoken", "jjwt-jackson", jwtVersion)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
