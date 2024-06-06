// Generated by Dagger (https://dagger.dev).
package com.example.searchgithubprofile.di;

import com.example.searchgithubprofile.network.GithubService;
import com.example.searchgithubprofile.repo.GithubRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class RepositoryModule_ProvideGithubRepositoryFactory implements Factory<GithubRepository> {
  private final Provider<GithubService> serviceProvider;

  public RepositoryModule_ProvideGithubRepositoryFactory(Provider<GithubService> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public GithubRepository get() {
    return provideGithubRepository(serviceProvider.get());
  }

  public static RepositoryModule_ProvideGithubRepositoryFactory create(
      Provider<GithubService> serviceProvider) {
    return new RepositoryModule_ProvideGithubRepositoryFactory(serviceProvider);
  }

  public static GithubRepository provideGithubRepository(GithubService service) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideGithubRepository(service));
  }
}