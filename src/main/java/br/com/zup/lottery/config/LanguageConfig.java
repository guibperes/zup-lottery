package br.com.zup.lottery.config;

import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LanguageConfig {

  public LocaleResolver localeResolver() {
    var sessionLocaleResolver = new SessionLocaleResolver();

    sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
    return sessionLocaleResolver;
  }
}
