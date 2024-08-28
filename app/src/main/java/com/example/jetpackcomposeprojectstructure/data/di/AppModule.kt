package com.example.jetpackcomposeprojectstructure

import android.content.Context
import androidx.room.Room
import com.example.jetpackcomposeprojectstructure.data.local.AppDatabase
import com.example.jetpackcomposeprojectstructure.data.local.dao.UserDao
import com.example.jetpackcomposeprojectstructure.data.remote.ApiClient
import com.example.jetpackcomposeprojectstructure.data.remote.api.ApiService
import com.example.jetpackcomposeprojectstructure.data.repository.UserRepositoryImpl
import com.example.jetpackcomposeprojectstructure.domain.repository.UserRepository
import com.example.jetpackcomposeprojectstructure.domain.usercas.GetObjectsUseCase
import com.example.jetpackcomposeprojectstructure.domain.usercas.LoginUseCase
import com.example.jetpackcomposeprojectstructure.presentation.viewmodel.ObjectViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiClient.create()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "app_database"
        ).build()
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    fun provideUserRepository(
        apiService: ApiService,
        userDao: UserDao,
    ): UserRepository {
        return UserRepositoryImpl(apiService, userDao)
    }

    @Provides
    fun provideLoginUseCase(userRepository: UserRepository): LoginUseCase {
        return LoginUseCase(userRepository)
    }


    @Provides
    fun provideGetObjectsUseCase(repository: UserRepository): GetObjectsUseCase {
        return GetObjectsUseCase(repository)
    }

    @Provides
    fun provideObjectViewModelFactory(
        getObjectsUseCase: GetObjectsUseCase,
    ): ObjectViewModelFactory {
        return ObjectViewModelFactory(getObjectsUseCase)
    }
}
