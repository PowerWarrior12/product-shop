repositories {
    mavenCentral()
}

plugins {
    id("java")
    id("com.github.johnrengelman.shadow")
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
}
tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.example.ProductShopApplication"
    }
    from ({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

dependencies {
    testImplementation("junit:junit:4.13.1")
    testImplementation("junit:junit:4.13.1")
    val springBootVer = "3.1.2"
    val flywayVer = "9.22.0"
    val postgresqlVer = "42.6.0"
    val lombokVer = "1.18.28"
    val jwtVer = "4.4.0"

    //Spring-Boot
    //Core
    implementation("org.springframework.boot:spring-boot-starter:$springBootVer")
    //Web
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVer")
    //Jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVer")
    //Security
    implementation("org.springframework.boot:spring-boot-starter-security:$springBootVer")

    //Postgresql
    implementation("org.postgresql:postgresql:$postgresqlVer")
    //Flyway
    implementation("org.flywaydb:flyway-core:$flywayVer")
    //JWT
    // https://mvnrepository.com/artifact/com.auth0/java-jwt
    implementation("com.auth0:java-jwt:$jwtVer")

    //Lombok
    compileOnly("org.projectlombok:lombok:$lombokVer")
    annotationProcessor("org.projectlombok:lombok:$lombokVer")
    //Log4j
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")


    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:5.5.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVer")// https://mvnrepository.com/artifact/com.h2database/h2
    testImplementation("com.h2database:h2:2.2.224")
    testImplementation("io.github.yashchenkon:assertsqlcount:1.1.0")
}

tasks.test {
    useJUnitPlatform()
}