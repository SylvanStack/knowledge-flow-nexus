# KFN(Knowledge Flow Nexus)

KFN是一个面向所有用户的知识自动化平台，使人人都能快速构建和发布高质量内容，无需深厚的技术背景。

## 项目核心目标

打造一个面向所有用户的知识自动化平台，使人人都能快速构建和发布高质量内容，无需深厚的技术背景。

## 主要功能模块

1. **用户友好的知识源管理**
   - 多样化数据源接入：支持文档、网页、音频、视频等多种格式
   - 智能数据抓取工具：一键导入各类平台内容
   - 数据自动更新机制：保持知识库时效性

2. **简易知识内容创作**
   - 模板库：提供多种内容模板，适应不同场景需求
   - AI辅助写作：智能补全、润色和改进建议
   - 协作编辑：支持多人实时协作创作
   - 可视化编辑器：降低技术门槛

3. **一键式知识发布**
   - 多平台发布：支持网站、社交媒体、电子书等多渠道发布
   - 自动排版：智能适配不同平台的内容展示要求
   - 定时发布：设置发布计划，自动执行

4. **简化的LLM管理**
   - 预设模型库：提供优化过的各类模型供选择
   - 无代码模型调优：通过界面操作调整模型参数
   - 模型性能监控：直观展示模型效果和改进空间

5. **傻瓜式RAG构建**
   - 自动化知识库构建：一键将数据转化为高质量知识库
   - 智能问答优化：自动提升检索和生成质量
   - 评估与反馈：提供易懂的性能指标和改进建议

6. **用户体验优化**
   - 简洁直观的界面：降低学习成本
   - 进度跟踪：提供内容创建到发布的全流程可视化
   - 个性化推荐：基于用户习惯提供优化建议

## 技术架构

本项目采用前后端分离架构：

### 前端技术栈
- 框架：React.js
- 状态管理：Redux
- UI组件库：Ant Design
- 构建工具：Vite
- 客户端路由：React Router
- API通信：Axios
- 实时通信：Socket.IO 客户端

### 后端技术栈
- 主框架：Java + SpringBoot + SpringAI
- ORM框架：MyBatis
- 数据库：MySQL (主数据存储)
- 缓存：Redis
- 消息队列：Kafka
- 安全框架：Spring Security
- API文档：Swagger
- 单元测试：JUnit, Mockito
- 日志框架：Logback, SLF4J
- 架构模式：领域驱动设计(DDD)四层架构

### 算法服务技术栈
- 语言：Python
- 框架：FastAPI, Flask
- 算法库：PyTorch, TensorFlow, Hugging Face Transformers, OpenCV, Whisper
- 部署：Docker, Kubernetes
- 文档：Swagger, ReDoc
- 测试：Pytest

### DevOps 与部署
- 容器化：Docker
- 编排：Kubernetes
- CI/CD：GitHub Actions
- 日志管理：ELK Stack
- 监控：Prometheus, Grafana

## 系统架构图

```
┌────────────────┐     ┌─────────────────┐     ┌───────────────────────────┐
│                │     │                 │     │                           │
│    前端应用    │─────▶    API网关      │─────▶    SpringBoot服务        │
│    React.js    │     │                 │     │    (DDD四层架构)          │
│                │     │                 │     └───────────┬───┬───────────┘
└────────────────┘     │                 │                 │   │
                      │                 │                 │   │
                      │                 │     ┌───────────▼───▼───────────┐
                      │                 │     │                           │
                      │                 │─────▶     Python算法服务        │
                      │                 │     │   (语音/视频/文本/图像等)  │
                      └─────────────────┘     │                           │
                                              └───────────────────────────┘
                                                          │
                                                          │
                                              ┌───────────▼───────────────┐
                                              │                           │
                                              │       数据服务层          │
                                              │    MySQL / Redis / Kafka  │
                                              │    MinIO / 向量数据库      │
                                              │                           │
                                              └───────────────────────────┘
```

## 项目文档

- [网站规划](01-网站规划.md) - 项目整体功能规划和核心目标
- [网站设计示意图](2.%20网站设计示意图-知识源管理.md) - 各功能模块的UI设计示意图
- [项目代码架构设计](3.%20项目代码架构设计文档.md) - 项目技术架构设计和组件关系
- [后端目录结构](3.%20后端目录结构.md) - 后端DDD架构目录结构
- [前端目录结构](3.%20前端目录结构.md) - 前端组件目录结构
- [算法服务目录结构](3.%20算法服务目录结构.md) - 算法服务设计文档
- [整体目录结构](3.%20整体目录结构.md) - 项目整体文件组织结构
- [开发日志](UPDATE_LOG.md) - 项目开发进度和重要决策记录

## 设计原则

- **易用性优先**：确保非技术用户也能高效使用
- **自动化为核心**：减少手动操作步骤，提升效率
- **内容质量反馈**：帮助用户持续改进内容质量
- **模块化设计**：系统按功能模块划分，每个模块相对独立
- **可扩展性**：系统设计支持功能扩展和第三方服务集成
- **安全性**：实现数据安全和用户权限控制

## 运行项目

### 前置条件
- Java JDK 17+
- Node.js (v16+)
- Docker & Docker Compose
- MySQL
- Redis
- Kafka
- Python 3.10+ (算法服务)

### 开发环境启动
```bash
# 克隆仓库
git clone https://github.com/yourusername/knowledge-flow-nexus.git
cd knowledge-flow-nexus

# 启动数据库和服务
docker-compose up -d

# 启动后端服务
cd knowledge-flow-nexus-backend
./mvnw spring-boot:run

# 启动前端
cd knowledge-flow-nexus-front
npm install
npm run dev

# 启动算法服务(可选)
cd knowledge-flow-nexus-algo
python -m venv venv
source venv/bin/activate  # Windows: venv\Scripts\activate
pip install -r requirements.txt
python -m speech.app.main  # 或其他算法服务
```

## 贡献指南

欢迎贡献代码和提出建议！请参阅[贡献指南](CONTRIBUTING.md)了解详情。

## 许可证

本项目采用MIT许可证 - 查看[LICENSE](LICENSE)文件了解详情。

## 开发日志

### 2025-04-12 项目规划以及产品、技术方案设计
- 会话主要目的：确定项目核心定位、技术架构和开发规范
- 完成的主要任务：
  - 确定项目名称与核心目标
  - 完成技术选型与系统架构设计
  - 规划功能模块与数据流
  - 完成数据库设计与缓存策略
  - 构建DDD四层架构目录结构
- 使用的技术栈：React/Redux、SpringBoot、Python/FastAPI、MySQL、Redis、Kafka
- 产出文件：架构设计文档、目录结构设计、开发日志更新
