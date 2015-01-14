package com.vlkan.springdataneo4jdemo;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories("com.vlkan.springdataneo4jdemo.repository")
public class RepositoryConfiguration extends Neo4jConfiguration {

    private final String storeDirectory = "target/neo4j-db-plain";

    public RepositoryConfiguration() {
        setBasePackage("com.vlkan.springdataneo4jdemo.domain");
    }

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase(storeDirectory);
    }

}
