plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    val springBootVer = "3.1.3"
    val flywayVer = "9.22.0"
    val postgresqlVer = "42.6.0"
    val lombokVer = "1.18.28"

    implementation("org.springframework.boot:spring-boot-starter:$springBootVer")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootVer")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVer")

    implementation("org.postgresql:postgresql:$postgresqlVer")

    implementation("org.flywaydb:flyway-core:$flywayVer")

    compileOnly("org.projectlombok:lombok:$lombokVer")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}