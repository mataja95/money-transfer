docker-compose.yml - creates mysql container and java container using dockerfile

Dockerfile - runs wait-and-run.sh where

scripts/ contains wait-and-run:
MYSQL client is installed to check whether MYSQL has been installed.
The status of the installation is continually checked.
If MYSQL has installed successfully, then run java app.

