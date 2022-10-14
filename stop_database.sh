#!/usr/bin/env bash

docker-compose -f database.yml down
docker volume prune --force