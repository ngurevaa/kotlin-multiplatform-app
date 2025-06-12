import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.composeCompiler)

}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "CommonKmp"
            isStatic = true
        }
    }
//    iosX64()
//    iosArm64()
//    iosSimulatorArm64()

    jvm()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")

        pod("FirebaseAuth") {
            version = "~> 10.0"
        }
//        pod("Firebase/Core") {
//            version = "10.16.0"
//        }
//        pod("Firebase/Firestore") {
//            version = "10.16.0"
//        }
//        pod("Firebase/Analytics") {
//            version = "10.16.0"
//        }
//        pod("Firebase/Crashlytics") {
//            version = "~> 10.16.0"
//        }
//        framework {
//            baseName = "CommonKmp"
//            transitiveExport = true
//            isStatic = true
            /*
            * export
            * случае экспорта модуля, для него генерятся нормальные obj-c хэдеры и со стороны айоса доступны все декларации,
            * которые в нём объявлены. Без экспорта доступны только транзитивные штуки
            * (например, если класс используется в shared или других экспортируемых модулях),
            * имена будут с префиксом названия модуля, что-то типа FeatureNameSomeClassName
            * */
//        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.ktorClientCommon)
            implementation(libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)

            implementation(libs.multiplatform.settings)
            implementation(libs.multiplatform.settings.serialization)

            implementation(libs.sqldelight.sqlite.adapter)
            implementation(libs.sqldelight.coroutines.extensions)

            implementation(libs.koin.core)
            implementation(libs.koin.compose.vm)

            implementation(libs.androidx.lifecycle.viewmodel)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.okhttp3.logging.interceptor)
            implementation(libs.kotlinx.coroutines.android)

            implementation(libs.sqldelight.android.driver)

            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.ui.tooling)
            implementation(libs.compose.material3)
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)

            implementation(libs.androidx.lifecycle.runtime)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.androidx.lifecycle.viewmodel.compose)

            implementation(libs.coil)
            implementation(libs.coilCompose)

            implementation(libs.timber)

            implementation(libs.koin.compose.vm)

            implementation(project.dependencies.platform(libs.firebase.bom))
            implementation(libs.firebase.auth)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
            implementation(libs.sqldelight.native.driver)
        }
        jvmMain.dependencies {
            implementation(libs.kotlinx.coroutines.desktop)
            implementation(libs.ktor.client.desktop)
            implementation(libs.sqldelight.sqlite.driver)

            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.ui.tooling)
            implementation(libs.compose.material3)
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)

            implementation(libs.koin.compose.vm)
        }
    }
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("ru.kpfu.itis.kmp")
        }
    }
}

android {
    namespace = "ru.kpfu.itis.kmp.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
