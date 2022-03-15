docker exec --interactive --tty broker \
kafka-console-consumer --bootstrap-server broker:9092 \
                       --topic OrderCreatedEvent-new \
		       --consumer-property group.id=g3 \
		       --from-beginning
                       
