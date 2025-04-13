FROM maven:3.8.6-openjdk-17-slim AS build

WORKDIR /app

# 复制POM文件
COPY ./pom.xml ./pom.xml
COPY ./knowledge-flow-nexus-api/pom.xml ./knowledge-flow-nexus-api/pom.xml
COPY ./knowledge-flow-nexus-app/pom.xml ./knowledge-flow-nexus-app/pom.xml
COPY ./knowledge-flow-nexus-domain/pom.xml ./knowledge-flow-nexus-domain/pom.xml
COPY ./knowledge-flow-nexus-infrastructure/pom.xml ./knowledge-flow-nexus-infrastructure/pom.xml
COPY ./knowledge-flow-nexus-trigger/pom.xml ./knowledge-flow-nexus-trigger/pom.xml
COPY ./knowledge-flow-nexus-types/pom.xml ./knowledge-flow-nexus-types/pom.xml

# 下载依赖（利用Docker缓存）
RUN mvn dependency:go-offline -B

# 复制源代码
COPY ./knowledge-flow-nexus-api/src ./knowledge-flow-nexus-api/src
COPY ./knowledge-flow-nexus-app/src ./knowledge-flow-nexus-app/src
COPY ./knowledge-flow-nexus-domain/src ./knowledge-flow-nexus-domain/src
COPY ./knowledge-flow-nexus-infrastructure/src ./knowledge-flow-nexus-infrastructure/src
COPY ./knowledge-flow-nexus-trigger/src ./knowledge-flow-nexus-trigger/src
COPY ./knowledge-flow-nexus-types/src ./knowledge-flow-nexus-types/src

# 构建项目
RUN mvn package -DskipTests

# 运行阶段
FROM openjdk:17-jdk-slim

WORKDIR /app

# 复制构建好的jar文件
COPY --from=build /app/knowledge-flow-nexus-app/target/knowledge-flow-nexus-app-*.jar /app/app.jar

# 运行应用
ENTRYPOINT ["java", "-jar", "/app/app.jar"] 