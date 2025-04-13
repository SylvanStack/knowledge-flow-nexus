# Knowledge Flow Nexus - 后端服务

Knowledge Flow Nexus是一个面向所有用户的知识自动化平台，使人人都能快速构建和发布高质量内容，无需深厚的技术背景。

## 项目结构

项目采用DDD（领域驱动设计）四层架构：
- API层：定义接口和数据传输对象（DTO）
- 应用层：协调各领域服务，实现业务流程
- 领域层：核心业务逻辑，包含领域模型、服务和仓储接口
- 基础设施层：实现仓储接口，对接外部系统

```
├── knowledge-flow-nexus-api        # API层
├── knowledge-flow-nexus-app        # 应用层
├── knowledge-flow-nexus-domain     # 领域层
├── knowledge-flow-nexus-infrastructure # 基础设施层
├── knowledge-flow-nexus-trigger    # 触发器层（Controller等）
└── knowledge-flow-nexus-types      # 公共类型和常量
```

## 技术栈

- 核心框架：Spring Boot 3.2.0
- 持久层：MyBatis 3.5.14
- 数据库：MySQL 8.0
- 缓存：Redis
- 消息队列：Kafka
- 对象存储：Minio
- API文档：Springdoc-OpenAPI 2.3.0
- AI集成：Spring AI 0.8.0
- 工具库：Lombok、MapStruct、Apache Commons等

## 主要功能模块

### 知识源管理
- 支持多种存储系统：Minio、OSS、OBS、SMB、NAS等
- 支持多类型知识导入：文档、网页、音频、视频等
- 智能数据抓取
- 数据自动更新
- 在线浏览和预览

### 知识内容创作
- 模板库
- AI辅助写作
- 协作编辑
- 可视化编辑器

### 知识发布
- 多平台发布
- 自动排版
- 定时发布

### LLM管理
- 预设模型库
- 无代码模型调优
- 模型性能监控

### RAG构建
- 自动化知识库构建
- 智能问答优化
- 评估与反馈

## 快速开始

### 环境要求
- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- Redis 6.0+
- Kafka 3.0+
- Minio (可选)

### 安装运行

1. 克隆项目

```bash
git clone https://github.com/yourusername/knowledge-flow-nexus.git
cd knowledge-flow-nexus
```

2. 编译打包

```bash
mvn clean install
```

3. 运行应用

```bash
cd knowledge-flow-nexus-backend/knowledge-flow-nexus-app
mvn spring-boot:run
```

4. 访问API文档

```
http://localhost:8080/swagger-ui.html
```

## 配置示例

配置文件位于：`knowledge-flow-nexus-app/src/main/resources/application.yml`

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/knowledge_flow_nexus?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    password: root

# Minio配置
minio:
  endpoint: http://localhost:9000
  access-key: minioadmin
  secret-key: minioadmin
  bucket: knowledge-flow-nexus
```

## 接口文档

项目集成了Springdoc-OpenAPI，启动应用后可通过以下地址访问API文档：

- Swagger UI：`http://localhost:8080/swagger-ui.html`
- OpenAPI描述：`http://localhost:8080/v3/api-docs`

## 贡献指南

1. Fork 项目
2. 创建特性分支 (`git checkout -b feature/amazing-feature`)
3. 提交您的更改 (`git commit -m 'Add some amazing feature'`)
4. 推送到分支 (`git push origin feature/amazing-feature`)
5. 打开Pull Request

## 许可证

本项目采用 MIT 许可证 - 详情参见 [LICENSE](LICENSE) 文件 