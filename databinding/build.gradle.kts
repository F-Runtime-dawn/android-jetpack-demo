plugins {
	alias(libs.plugins.com.android.library)
	alias(libs.plugins.org.jetbrains.kotlin.android)
	//databinding需要kapt，而ksp此时不能替代
	id("kotlin-kapt")
}

android {
	namespace = "org.zhiwei.jetpack.databinding"
	compileSdk = 33

	defaultConfig {
		minSdk = 24

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	buildFeatures {
		//模块化中的databinding开启，则app主module中也要开启
		dataBinding = true
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}
	kotlinOptions {
		jvmTarget = "17"
	}
}

dependencies {

	// android official libs version
	implementation(libs.activity.ktx)
	implementation(libs.appcompat)
	implementation(libs.constraintlayout)
	implementation(libs.core.ktx)
	implementation(libs.fragment.ktx)
	implementation(libs.material)
	implementation(libs.recyclerview)
	implementation(libs.swiperefreshlayout)

	implementation(libs.coil.kt)
	implementation(libs.coil.kt.svg)

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.test.ext.junit)
	androidTestImplementation(libs.espresso.core)
}