plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("com.google.dagger.hilt.android") version "2.44" apply false
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {

}