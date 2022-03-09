docker exec --interactive --tty broker \
kafka-topics --bootstrap-server broker:9092 \
	     --delete --topic OrderCreatedEvent

