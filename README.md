This is a demo for multi-host Docker Swarm microservice deployment, with log aggregation and metrics.

Stack:
* Docker Swarm (1 manager and 2 worker nodes)
* simple Spring Boot app for dummy load (prime numbers generation)
* ELK stack for log aggregation and Logspout as a Docker-compatible drop-in log harvester
* Grafana + InfluxDB + cAdvisor for collecting metrics

Running:
* create 3 or more Linux machines (using vagrant or any public cloud)
* copy `hosts.sample` to `hosts` and fill in IP addresses
* run `ansible-playbook -i hosts site.yml -v` to provision hosts with Swarm
* run `ansible-playbook -i hosts deploy.yml -v` to create all services

Inspecting:
* Kibana: http://IPADDRESS:8000/app/kibana
* Grafana: http://IPADDRESS:8002/dashboard/db/swarm-dashboard (admin/admin)
* Prime numbers microservice: http://IPADDRESS:8080/generate/1000 (change the number of primes to vary the load)
