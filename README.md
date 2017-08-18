# Docker for Enterprise Developers
This repository contains the seed for all the labs/exercises executed during the Docker for Enterprise Developers (DDEV) workshop. Most of the exercises are base on a sample application that consists of 3 services

* a Postgres database
* a Java Spring-Boot API
* a Node JS based UI

Each service runs in its own container.

## Labs
In this repository we have the following labs

Repository | Description
-----------|------------
ddev-seed                | Sample application explained
edit-and-continue        | Exercise to demonstrate **Edit and Continue**
debugging                | Demonstrates debugging inside a container
unit-tests               | How to write unit tests against the Node JS UI
unit-tests-dot-net       | How to write unit tests in C# on .NET
api-tests                | How to write API tests against the Java API
api-tests-flask          | Example for API tests using Python/Flask
end-2-end-tests          | Create end to end tests for the sample application
docker-compose           | Creating compose files for different development and test scenarios
builder                  | Various exercises on building container images
logging                  | Add logging to the Java API
error-handling           | Add error handling the Java API
defensive-programming    | Example on how to code defensively
health-checks            | Implement health checks for the Java API
service-discovery        | Demonstrate service discovery in action
secrets                  | Use a secret in the Java API
configuration-management | Exercise various aspects of configuration management
tagging-and-versioning   | Exercising various aspects of tagging and versioning
dtr-ci-cd                | Setting up a simple CI pipeline using Jenkins

## Running the Seed Application
1. Clone this repository to a local folder, e.g.:

    ```
    $ cd ~
    $ git clone -b 17.06 https://github.com/docker-training/ddev-labs.git
    $ cd ddev-labs/ddev-seed
    ```

2. Run the application:

    ```
    $ docker-compose up --build
    ```

3. Open a browser and navigate to `http://localhost:3000/pet`. You should see a cat GIF. 
4. Refresh the browser view multiple times to see other funny GIFs.
5. Also try to use the API directly using `curl`, e.g.:

    ```
    $ curl localhost:8080/api/pet
    # or
    $ curl localhost:8080/api/images/
    # and
    $ curl localhost:8080/api/images/5
    ```

## Debugging the Application
Run the application using the `docker-compose-api.yml` file:

```
docker-compose -f docker-compose-api.yml up --build
```

If we want to debug the Java based API we need to install an IDE that supports remote debugging. In our case we recommend the use of Eclipse. If you do not already have it installed then please do so from [https://www.eclipse.org/downloads/](https://www.eclipse.org/downloads/).

Once Eclipse is installed and running go to **File-->Import** and select **Existing Maven Projects**. Navigate to the `~ddev` folder and import the project.

Now go to **Run-->Debug Configurations** and select **Remote Java Applications** and hit the **New launch configuration** button to create a new configuration. Fill in `Host: localhost` and `Port: 5005`. Click **Apply** and then **Debug**. The API will now ber initialized as you can see in the terminal window. The debugger is attached to the process running inside the container. You can put breakpoints in you code and start debugging. 