# Chain of Responsibility Design Pattern (Java Implementation)

**Chain of Responsibility** design pattern build a pipeline of processing objects for a request.
### Problem: 
You have a **WebServer** and you want to handle **HttpRequest** in a pipeline of objects handlers.

**Two Issues:**
1. **WebServer** is tightly coopled with **Authenticator**, **Logger**, **Compressor**. (because of **new** keywords)
2. Adding, disabling, reordering any step of this **pipeline** need to hardcode it in **WebServer**.

---

    public class WebServer {
        public void handle(HttpRequest request) {
            //Authenticate
            (new Authenticator).authenticate(request);
            
            //Logging
            (new Logger).log(request);

            //Compressing
            (new Compressor).compress(request);
        }
    }

    public class HttpRequest {
        private String username;
        private String password;
        
        public HttpRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public class Authenticator {
        public boolean authenticate(HttpRequest request) {
            boolean isValid = request.getUsername() == "admin" && request.getPassword() == "1234";
            System.out.println("Authentication");
            return isValid;
        }
    }

    public class Logger {
        public void log(HttpRequest request) {
            System.out.println("Log.");
        }
    }

    public class Compressor {
        public boolean compress(HttpRequest request) {
            System.out.println("Compress.");
            return false;
        }
    }
### Solution:
![](https://github.com/shamy1st/design-pattern-chain-of-responsibility-java/blob/main/chain-of-responsibility-solution-uml.png)
