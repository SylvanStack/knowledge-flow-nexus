## 开发日志

## 2025-04-12 项目规划以及产品、技术方案设计
- **会话主要目的**：确定项目核心定位、技术架构和开发规范

- **完成的主要任务**：
  - 确定项目名称与核心目标：KFN(Knowledge Flow Nexus)，打造面向所有用户的知识自动化平台
  - 完成技术选型：前端(React生态)、后端(Java生态)、算法服务(Python生态)
  - 设计整体系统架构：前后端分离 + 微服务 + DDD四层架构
  - 规划核心功能模块与数据流
  - 创建项目基础文件结构与代码组织方式
  - 设计五个主要算法服务模块及其交互方式
  - 完成数据库设计与缓存策略
  - 构建领域驱动设计(DDD)四层架构目录结构

- **关键决策**：
  - 数据存储：PostgreSQL/MongoDB为主，后期调整为MySQL
  - 缓存与消息：Redis缓存 + Kafka消息队列
  - 开发模式：DDD领域驱动设计，清晰分层，职责分明
  - 部署策略：Docker容器化 + Kubernetes编排
  - 数据库设计简化：仅包含必要数据表，优化性能
  - DDD架构实现：Adapter、App、Domain和Infrastructure四层职责明确

- **技术栈**：
  - 前端：React + Redux + Ant Design + Vite
  - 后端：SpringBoot + SpringAI + MyBatis + Spring Security
  - 算法：Python + FastAPI + PyTorch/TensorFlow + 各专业算法库
  - 数据层：PostgreSQL/MongoDB(初期)，MySQL(后期) + Redis + Kafka
  - 文档处理：Apache POI(文档解析)、JSoup(网页抓取)
  - 部署：Docker + Kubernetes + Nginx

- **产出文件**：
  - 架构设计文档：`3. 架构设计文档.md`
  - 目录结构设计：`3. 后端目录结构.md`、`3. 前端目录结构.md`、`3. 算法服务目录结构.md`
  - 开发日志：`UPDATE_LOG.md`更新