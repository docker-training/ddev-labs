# Docker for Enterprise Developers
## Workshop Sample Application - Seed
This repository contains the seed for the sample application used during the Docker for Enterprise Developers (DDEV) workshop. The application consists of 3 services

* a Postgres database
* a Java Spring-Boot API
* a Node JS based UI

Each service runs in its own container.

## Running the Application
1. Clone this repository to a local folder, e.g.:

    ```
    $ cd ~
    $ git clone https://github.com/docker-training/ddev-sample.git ddev
    $ cd ddev
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