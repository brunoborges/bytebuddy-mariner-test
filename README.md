# bytebuddy-mariner-test

To run the test, simply build a container image based on the `Dockerfile` present in this project.

```bash
$ docker build -t test .
```

It will build the project, run the JUnit test, and then run again the test as a standalone Java application.
