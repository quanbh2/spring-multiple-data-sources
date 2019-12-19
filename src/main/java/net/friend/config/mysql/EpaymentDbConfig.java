package net.friend.config.mysql;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "epaymentEMF", basePackages = {
    "net.friend.repository.mysql.epayment"}, transactionManagerRef = "epaymentTM")
public class EpaymentDbConfig {

  @Autowired(required = false)
  private PersistenceUnitManager persistenceUnitManager;

  Map<String, ?> jpaProperties = new HashMap<>();

  @Bean(name = "epayment_ds")
  @ConfigurationProperties(prefix = "mysql.epayment")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "epayment_emfb")
  public EntityManagerFactoryBuilder entityManagerFactoryBuilder1() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    // adapter.setShowSql(true);
    adapter.setDatabase(Database.MYSQL);
    adapter.setGenerateDdl(true);
    EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(adapter,
        this.jpaProperties,
        this.persistenceUnitManager);
    return builder;
  }

  @Bean(name = "epaymentEMF")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      @Qualifier("epayment_ds") DataSource dataSource,
      @Qualifier("epayment_emfb") EntityManagerFactoryBuilder factoryBuilder) {
    Map<String, Object> vendorProperties = new HashMap<String, Object>();
//    vendorProperties.put("hibernate.hbm2ddl.auto", "create-drop");
//    vendorProperties.put("hibernate.hbm2ddl.import_files", "import1.sql");
    return factoryBuilder.dataSource(dataSource).packages("net.friend.domain.mysql.epayment")
        .properties(vendorProperties).build();
  }

  @Bean(name = "epaymentTM")
  public PlatformTransactionManager transactionManager(
      @Qualifier("epaymentEMF") EntityManagerFactory emf) {
    JpaTransactionManager manager = new JpaTransactionManager(emf);
    return manager;
  }

}
