#!/usr/bin/env bash
docker-compose -f start_application.yml down
docker volume prune --force