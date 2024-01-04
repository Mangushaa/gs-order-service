custom_build(
    ref="ghcr.io/mangushaa/gs-order-service:1",
    command='mvnw spring-boot:build-image -Dsping.boot.image-name=ghcr.io/mangushaa/gs-order-service:1',
    tag='1',
    deps=['pom.xml', 'src']
)

k8s_yaml(['k8s/gs-order-service-db.yml', 'k8s/gs-order-service.yml'])
k8s_resource(workload='gs-order-service', port_forwards=['8082:8082','5001:5001'])
