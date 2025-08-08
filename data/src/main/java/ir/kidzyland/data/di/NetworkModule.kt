package ir.kidzyland.data.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.kidzyland.data.model.response.adapter.NetworkResponseAdapterFactory
import jakarta.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


//    @Provides
//    @Singleton
//    fun provideOkHttpClient(
//        headerInterceptor: HeaderInterceptor,
//        tokenAuthenticator: TokenAuthenticator,
//        certificateChecker: CertificateChecker,
//    ): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(headerInterceptor)
//            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//            .authenticator(tokenAuthenticator)
//            .hostnameVerifier(certificateChecker)
//            .connectTimeout(BuildConfig.CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
//            .readTimeout(BuildConfig.READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
//            .writeTimeout(BuildConfig.WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
//            .build()
//    }

//    @Provides
//    @Singleton
//    fun provideMoshi(): Moshi = Moshi.Builder()
//        .add(
//            PolymorphicJsonAdapterFactory.of(ReportBody::class.java, ReportBody::class.simpleName)
//                .withSubtype(CrashReportBody::class.java, CrashReportBody::class.simpleName)
//                .withSubtype(UploadFailedReportBody::class.java, UploadFailedReportBody::class.simpleName)
//                .withSubtype(UploadImageFailedReportBody::class.java, UploadImageFailedReportBody::class.simpleName)
//                .withSubtype(SupportReportBody::class.java, SupportReportBody::class.simpleName)
//                .withSubtype(ZybankHashFailedReportBody::class.java, ZybankHashFailedReportBody::class.simpleName)
//        )
//        .add(KotlinJsonAdapterFactory())
//        .build()

//    @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
//        return Retrofit.Builder()
//            .addCallAdapterFactory(NetworkResponseAdapterFactory())
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .baseUrl(BuildConfig.BASE_URL)
//            .client(okHttpClient)
//            .build()
//    }

}