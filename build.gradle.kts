plugins {
    id("java")
}

group = "school.mjc"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation("school.mjc:task-verifier:1.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}