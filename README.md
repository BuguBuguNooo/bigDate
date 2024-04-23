# BigDate 新闻事件发布平台

BigDate 是一个新闻事件发布平台的后端服务，使用 Spring Boot 构建，并集成了 Redis 用于缓存 JWT，以提高应用的性能和安全性。

## 功能

- 发布、编辑和删除新闻事件
- 用户注册和登录
- JWT 认证
- Redis 缓存

## 快速开始

以下指南将帮助你在本地环境上启动和运行项目。

### 先决条件

确保你的系统已经安装了以下软件：

- Java JDK 11 或更高版本
- Maven 3.6 或更高版本
- Redis 数据库

### 安装和运行

1. 克隆仓库到本地：
git clone https://your-repository-url
cd yellodate
2. 使用 Maven 构建项目：
./mvnw clean install
3. 启动应用程序：
./mvnw spring-boot:run
4. 访问 [http://localhost:8080](http://localhost:8080) 来查看应用。

## 配置

- 应用的配置文件位于 `src/main/resources/application.properties`，你可以根据需要修改数据库连接和其他配置。

## 开发者指南

你可以在 `src/main/java/com/gfj/yellodate` 目录下找到项目的主要 Java 代码。每个包的结构如下所示：

- `controller` - 包含所有的控制器文件，用于处理前端请求。
- `service` - 服务接口及其实现，处理业务逻辑。
- `repository` - 数据访问层，包括所有与数据库交互的操作。
- `model` - 数据模型和实体。
- `config` - 应用配置相关的Java类。
- `security` - 安全和认证相关的配置。

## 贡献

如果你有任何建议或改进，请提交 Pull Request 或开 Issue。

## 许可证

该项目采用 [MIT 许可证](LICENSE)。
