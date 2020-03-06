plugins {
    kotlin("jvm") version "1.3.61"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "com.uramnoil"
version = "0.1.0"

repositories {
    jcenter()
    maven {
        url = uri("https://repo.nukkitx.com/main/")
    }
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly("cn.nukkit", "nukkit", "1.0-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}