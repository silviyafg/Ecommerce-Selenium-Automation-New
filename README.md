# 🛒 Ecommerce Selenium Automation Project

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

---

## 📌 Project Overview

This is an end-to-end test automation project for the e-commerce website [Automation Exercise](https://automationexercise.com). It is built using **Selenium Java**, **Cucumber BDD**, and **TestNG** following the **Page Object Model (POM)** design pattern. The project covers both positive and negative test scenarios including authentication, product search, cart management, and checkout flows.

---

## 🌐 Application Under Test

| Detail | Info |
|---|---|
| Website | https://automationexercise.com |
| Type | E-commerce Web Application |
| Browser | Google Chrome |
| OS | Windows 10 |

---

## 🛠️ Tech Stack

| Tool | Purpose |
|---|---|
| Java 17+ | Programming Language |
| Selenium WebDriver 4.x | Browser Automation |
| Cucumber BDD 7.x | Behaviour Driven Development |
| TestNG 7.x | Test Framework |
| Maven | Build & Dependency Management |
| WebDriverManager | Automatic Driver Management |
| Extent Reports | HTML Test Reports |
| Page Object Model | Design Pattern |

---

## 📁 Project Structure

```
Ecommerce/
├── src/
│   └── test/
│       ├── java/
│       │   ├── config/
│       │   │   └── Hooks.java              # Before/After cucumber hooks
│       │   ├── pages/
│       │   │   └── EcommercePages.java     # Page Object Model classes
│       │   ├── stepDefinition/
│       │   │   └── Ecommerce.java          # Cucumber step definitions
│       │   ├── runner/
│       │   │   └── TestRunner.java         # Cucumber test runner
│       │   └── Utils/
│       │       └── ElementsUtil.java       # Reusable Selenium utilities
│       └── resources/
│           ├── features/
│           │   ├── Login.feature
│           │   ├── Search.feature
│           │   ├── Cart.feature
│           │   └── Checkout.feature
│           └── extensions/
│               └── Stands_AdBlocker.crx    # Ad blocker extension
├── target/
│   └── cucumber-reports/
│       └── cucumber.html                   # Test reports
├── .gitignore
├── pom.xml
└── README.md
```

---

## ⚙️ Prerequisites

Make sure you have the following installed:

- Java JDK 17 or above — https://adoptium.net
- Maven 3.9+ — https://maven.apache.org
- Google Chrome (latest)
- IntelliJ IDEA (recommended)
- Git — https://git-scm.com

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/silviyafg/Ecommerce-Selenium-Automation-New.git
cd Ecommerce-Selenium-Automation
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Run All Tests

```bash
mvn clean test
```

### 4. Run Specific Feature

```bash
mvn test -Dcucumber.filter.tags="@Login"
```

---

## 🔧 Configuration

### pom.xml Dependencies

```xml
<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.18.1</version>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.7.0</version>
    </dependency>

    <!-- Cucumber Java -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.15.0</version>
    </dependency>

    <!-- Cucumber TestNG -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-testng</artifactId>
        <version>7.15.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.9.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## 🧪 Test Scenarios Covered

### ✅ Authentication
- Login with valid credentials
- Login with invalid credentials
- Login with unregistered email
- Verify logged in username is displayed

### ✅ Product Search
- Search for a product by name
- Search with invalid product name
- Verify search results match keyword

### ✅ Shopping Cart
- Add single product to cart
- Add multiple products to cart
- Verify product price in cart
- Remove product from cart
- Verify cart count updates

### ✅ Checkout Flow
- Complete end-to-end order placement
- Verify delivery address on checkout
- Place order with payment details
- Download invoice after order

### ✅ Product Details
- View product details page
- Add product with specific quantity
- Write a product review

### ✅ UI Validation
- Verify home page loads successfully
- Verify category section is displayed
- Verify Features Items section
- Verify scroll up and down behaviour

### ✅ Contact Form
- Submit contact form with valid details
- Subscribe to newsletter from footer

---

## 📊 Test Reports

After running tests, HTML reports are generated at:

```
target/cucumber-reports/cucumber.html
```

Open in any browser to view:
- Passed / Failed / Skipped scenarios
- Step-by-step execution details
- Screenshots on failure

---

## 🔑 Key Features

- **Page Object Model** — Clean separation of page elements and test logic
- **BDD with Cucumber** — Human readable feature files using Gherkin syntax
- **Explicit Waits** — WebDriverWait used throughout instead of Thread.sleep
- **Ad Handling** — JavaScript used to remove Google Ads that block elements
- **JS Click Fallback** — Handles ElementClickInterceptedException automatically
- **Screenshot on Failure** — Captures screenshots in @After hook
- **Reusable Utilities** — ElementsUtil class with common Selenium actions
- **AdBlocker Extension** — Chrome loaded with AdBlocker to reduce ad interference

---

## 📸 Sample Feature File

```gherkin
Feature: Login Functionality

  @Login
  Scenario: User logs in with valid credentials
    Given I am on the landing page of the e-commerce website
    When User clicks on Signup Login link
    And User enters email "test@gmail.com"
    And User enters password "password123"
    And User clicks on the login button in login page
    Then User performs validates the home page is displayed successfully
```

---

## 🧰 Utilities

### ElementsUtil.java

Reusable methods available:

| Method | Description |
|---|---|
| `click(By)` | Click with JS fallback |
| `clickUsingJS(By)` | Force click using JavaScript |
| `type(By, String)` | Clear and type text |
| `scrollIntoView(By)` | Scroll element into view |
| `isDisplayed(By)` | Returns true if element is visible |
| `getText(By)` | Returns element text |
| `waitForElementVisible(By)` | Explicit wait for visibility |
| `waitForElementClickable(By)` | Explicit wait for clickability |

---

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch — `git checkout -b feature/new-test`
3. Commit your changes — `git commit -m "Add new test scenario"`
4. Push to the branch — `git push origin feature/new-test`
5. Open a Pull Request

---

## 👨‍💻 Author

  Silviya 
- GitHub:[https://github.com/silviyafg/Ecommerce-Selenium-Automation-New/]
- LinkedIn: [https://linkedin.com/in/YourProfile](https://www.linkedin.com/in/silviya-gonsalves-b0b00aa4/)

---

## 📄 License

This project is for educational and portfolio purposes.

---

## 🙏 Acknowledgements

- [Automation Exercise](https://automationexercise.com) — Free e-commerce website for automation practice
- [Selenium Documentation](https://www.selenium.dev/documentation)
- [Cucumber Documentation](https://cucumber.io/docs)
- [TestNG Documentation](https://testng.org/doc)
