import java.math.BigDecimal

object Config {
    val kotlinVersion = "1.6.10"
    val kotlinStdLib = "stdlib-jdk8"

    val springBootVersion = "2.6.8"
    val kotlinCompatibleLanguageVersion = "1.4"

    val composeVersion = "1.1.1"

    object BuildPlugins {
        val androidGradle = "com.android.tools.build:gradle:7.2.0"
        val kotlinGradlePlugin = "gradle-plugin"
        val buildConfig = "com.github.gmazzo.buildconfig"
        val buildConfigVersion = "3.0.3"
        val springBoot = "org.springframework.boot"
        val springDependencyManagement = "io.spring.dependency-management"
        val springDependencyManagementVersion = "1.0.11.RELEASE"
        val gretty = "org.gretty"
        val grettyVersion = "4.0.0"
        val gradleMavenPublishPlugin = "com.vanniktech:gradle-maven-publish-plugin:0.18.0"
        val dokkaPlugin = "org.jetbrains.dokka:dokka-gradle-plugin:$kotlinVersion"
        val dokkaPluginAlias = "org.jetbrains.dokka"
        val composeGradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$composeVersion"
    }

    object Android {
        private val sdkVersion = 32

        val minSdkVersion = 14
        val minSdkVersionOkHttp = 21
        val minSdkVersionNdk = 16
        val minSdkVersionCompose = 21
        val targetSdkVersion = sdkVersion
        val compileSdkVersion = sdkVersion

        val abiFilters = listOf("x86", "armeabi-v7a", "x86_64", "arm64-v8a")

        fun shouldSkipDebugVariant(name: String): Boolean {
            return System.getenv("CI")?.toBoolean() ?: false && name == "debug"
        }
    }

    object Libs {
        val okHttpVersion = "4.9.2"
        val appCompat = "androidx.appcompat:appcompat:1.3.0"
        val timber = "com.jakewharton.timber:timber:4.7.1"
        val okhttpBom = "com.squareup.okhttp3:okhttp-bom:$okHttpVersion"
        val okhttp = "com.squareup.okhttp3:okhttp"
        val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.8.1"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"

        private val lifecycleVersion = "2.2.0"
        val lifecycleProcess = "androidx.lifecycle:lifecycle-process:$lifecycleVersion"
        val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        val androidxCore = "androidx.core:core:1.3.2"
        val androidxRecylerView = "androidx.recyclerview:recyclerview:1.2.1"

        val slf4jApi = "org.slf4j:slf4j-api:1.7.30"
        val slf4jJdk14 = "org.slf4j:slf4j-jdk14:1.7.30"
        val logbackVersion = "1.2.9"
        val logbackClassic = "ch.qos.logback:logback-classic:$logbackVersion"

        val log4j2Version = "2.17.0"
        val log4j2Api = "org.apache.logging.log4j:log4j-api:$log4j2Version"
        val log4j2Core = "org.apache.logging.log4j:log4j-core:$log4j2Version"

        val springBootStarter = "org.springframework.boot:spring-boot-starter:$springBootVersion"
        val springBootStarterTest = "org.springframework.boot:spring-boot-starter-test:$springBootVersion"
        val springBootStarterWeb = "org.springframework.boot:spring-boot-starter-web:$springBootVersion"
        val springBootStarterWebflux = "org.springframework.boot:spring-boot-starter-webflux:$springBootVersion"
        val springBootStarterAop = "org.springframework.boot:spring-boot-starter-aop:$springBootVersion"
        val springBootStarterSecurity = "org.springframework.boot:spring-boot-starter-security:$springBootVersion"
        val springBootStarterJdbc = "org.springframework.boot:spring-boot-starter-jdbc:$springBootVersion"

        val springWeb = "org.springframework:spring-webmvc"
        val springWebflux = "org.springframework:spring-webflux"
        val springSecurityWeb = "org.springframework.security:spring-security-web"
        val springSecurityConfig = "org.springframework.security:spring-security-config"
        val springAop = "org.springframework:spring-aop"
        val aspectj = "org.aspectj:aspectjweaver"
        val servletApi = "javax.servlet:javax.servlet-api:3.1.0"
        val servletApiJakarta = "jakarta.servlet:jakarta.servlet-api:5.0.0"

        val apacheHttpClient = "org.apache.httpcomponents.client5:httpclient5:5.0.4"

        private val retrofit2Version = "2.9.0"
        private val retrofit2Group = "com.squareup.retrofit2"
        val retrofit2 = "$retrofit2Group:retrofit:$retrofit2Version"
        val retrofit2Gson = "$retrofit2Group:converter-gson:$retrofit2Version"

        val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3"

        val fragment = "androidx.fragment:fragment-ktx:1.3.5"

        val reactorCore = "io.projectreactor:reactor-core:3.4.6"

        private val feignVersion = "11.6"
        val feignCore = "io.github.openfeign:feign-core:$feignVersion"
        val feignGson = "io.github.openfeign:feign-gson:$feignVersion"

        private val apolloVersion = "2.5.9"
        val apolloAndroid = "com.apollographql.apollo:apollo-runtime:$apolloVersion"
        val apolloCoroutines = "com.apollographql.apollo:apollo-coroutines-support:$apolloVersion"

        val p6spy = "p6spy:p6spy:3.9.1"

        val graphQlJava = "com.graphql-java:graphql-java:17.3"

        val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"
        val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib"

        private val navigationVersion = "2.4.2"
        val navigationRuntime = "androidx.navigation:navigation-runtime:$navigationVersion"
        // compose deps
        val composeNavigation = "androidx.navigation:navigation-compose:$navigationVersion"
        val composeActivity = "androidx.activity:activity-compose:1.4.0"
        val composeFoundation = "androidx.compose.foundation:foundation:$composeVersion"
        val composeFoundationLayout = "androidx.compose.foundation:foundation-layout:$composeVersion"
        val composeMaterial = "androidx.compose.material3:material3:1.0.0-alpha13"

        val apolloKotlin = "com.apollographql.apollo3:apollo-runtime:3.3.0"
    }

    object AnnotationProcessors {
        val springBootAutoConfigure = "org.springframework.boot:spring-boot-autoconfigure-processor"
        val springBootConfiguration = "org.springframework.boot:spring-boot-configuration-processor"
    }

    object TestLibs {
        private val androidxTestVersion = "1.4.0"
        private val espressoVersion = "3.4.0"

        val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
        val kotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
        val androidxCore = "androidx.test:core:$androidxTestVersion"
        val androidxRunner = "androidx.test:runner:$androidxTestVersion"
        val androidxTestCoreKtx = "androidx.test:core-ktx:$androidxTestVersion"
        val androidxTestRules = "androidx.test:rules:$androidxTestVersion"
        val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
        val espressoIdlingResource = "androidx.test.espresso:espresso-idling-resource:$espressoVersion"
        val androidxTestOrchestrator = "androidx.test:orchestrator:1.4.1"
        val androidxJunit = "androidx.test.ext:junit:1.1.3"
        val androidxCoreKtx = "androidx.core:core-ktx:1.7.0"
        val robolectric = "org.robolectric:robolectric:4.7.3"
        val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0"
        val mockitoInline = "org.mockito:mockito-inline:4.3.1"
        val awaitility = "org.awaitility:awaitility-kotlin:4.1.1"
        val mockWebserver = "com.squareup.okhttp3:mockwebserver:${Libs.okHttpVersion}"
        val mockWebserver4 = "com.squareup.okhttp3:mockwebserver:4.9.3"
        val jsonUnit = "net.javacrumbs.json-unit:json-unit:2.32.0"
        val hsqldb = "org.hsqldb:hsqldb:2.6.1"
        val javaFaker = "com.github.javafaker:javafaker:1.0.2"
    }

    object QualityPlugins {
        object Jacoco {
            val version = "0.8.7"
            val minimumCoverage = BigDecimal.valueOf(0.6)
        }
        val spotless = "com.diffplug.spotless"
        val spotlessVersion = "6.2.1"
        val errorProne = "net.ltgt.errorprone"
        val errorpronePlugin = "net.ltgt.gradle:gradle-errorprone-plugin:2.0.1"
        val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:0.42.0"
        val gradleVersions = "com.github.ben-manes.versions"
        val detekt = "io.gitlab.arturbosch.detekt"
        val detektVersion = "1.19.0"
        val detektPlugin = "io.gitlab.arturbosch.detekt"
        val binaryCompatibilityValidatorVersion = "0.8.0"
        val binaryCompatibilityValidatorPlugin = "org.jetbrains.kotlinx:binary-compatibility-validator:$binaryCompatibilityValidatorVersion"
        val binaryCompatibilityValidator = "org.jetbrains.kotlinx.binary-compatibility-validator"
    }

    object Sentry {
        val SENTRY_JAVA_SDK_NAME = "sentry.java"
        val SENTRY_ANDROID_SDK_NAME = "$SENTRY_JAVA_SDK_NAME.android"
        val SENTRY_TIMBER_SDK_NAME = "$SENTRY_ANDROID_SDK_NAME.timber"
        val SENTRY_LOGBACK_SDK_NAME = "$SENTRY_JAVA_SDK_NAME.logback"
        val SENTRY_JUL_SDK_NAME = "$SENTRY_JAVA_SDK_NAME.jul"
        val SENTRY_LOG4J2_SDK_NAME = "$SENTRY_JAVA_SDK_NAME.log4j2"
        val SENTRY_SPRING_SDK_NAME = "$SENTRY_JAVA_SDK_NAME.spring"
        val SENTRY_SPRING_BOOT_SDK_NAME = "$SENTRY_JAVA_SDK_NAME.spring-boot"
        val group = "io.sentry"
        val description = "SDK for sentry.io"
        val versionNameProp = "versionName"
    }

    object CompileOnly {
        private val nopenVersion = "1.0.1"

        val jetbrainsAnnotations = "org.jetbrains:annotations:23.0.0"
        val nopen = "com.jakewharton.nopen:nopen-annotations:$nopenVersion"
        val nopenChecker = "com.jakewharton.nopen:nopen-checker:$nopenVersion"
        val errorprone = "com.google.errorprone:error_prone_core:2.11.0"
        val errorProneNullAway = "com.uber.nullaway:nullaway:0.9.5"
    }

    object NativePlugins {
        val nativeBundlePlugin = "io.github.howardpang:androidNativeBundle:1.1.1"
        val nativeBundleExport = "com.ydq.android.gradle.native-aar.export"
    }
}
