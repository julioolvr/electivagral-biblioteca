databaseChangeLog = {

	changeSet(author: "julio (generated)", id: "1348359843026-1") {
		createTable(tableName: "Libro") {
			column(autoIncrement: "true", name: "idLibro", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "LibroPK")
			}

			column(name: "autor", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "cantEj", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "isbn", type: "varchar(20)") {
				constraints(nullable: "false")
			}

			column(name: "titulo", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "julio (generated)", id: "1348359843026-2") {
		createTable(tableName: "Prestamo") {
			column(autoIncrement: "true", name: "idPrestamo", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "PrestamoPK")
			}

			column(name: "fechaDevolucion", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "fechaPedido", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "fechaRealDevolucion", type: "datetime")

			column(name: "idLibro", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "idSocio", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "julio (generated)", id: "1348359843026-3") {
		createTable(tableName: "Reserva") {
			column(autoIncrement: "true", name: "idReserva", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "ReservaPK")
			}

			column(name: "fechaFinReserva", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "fechaReserva", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "idLibro", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "idSocio", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "julio (generated)", id: "1348359843026-4") {
		createTable(tableName: "Socio") {
			column(autoIncrement: "true", name: "idSocio", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "SocioPK")
			}

			column(name: "dni", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "nomUsuario", type: "varchar(20)") {
				constraints(nullable: "false")
			}

			column(name: "nombre", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(40)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "julio (generated)", id: "1348359843026-5") {
		addForeignKeyConstraint(baseColumnNames: "idLibro", baseTableName: "Prestamo", constraintName: "FKB7C8A31F10D0464E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "idLibro", referencedTableName: "Libro", referencesUniqueColumn: "false")
	}

	changeSet(author: "julio (generated)", id: "1348359843026-6") {
		addForeignKeyConstraint(baseColumnNames: "idSocio", baseTableName: "Prestamo", constraintName: "FKB7C8A31F119B0924", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "idSocio", referencedTableName: "Socio", referencesUniqueColumn: "false")
	}

	changeSet(author: "julio (generated)", id: "1348359843026-7") {
		addForeignKeyConstraint(baseColumnNames: "idLibro", baseTableName: "Reserva", constraintName: "FKA49CA49810D0464E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "idLibro", referencedTableName: "Libro", referencesUniqueColumn: "false")
	}

	changeSet(author: "julio (generated)", id: "1348359843026-8") {
		addForeignKeyConstraint(baseColumnNames: "idSocio", baseTableName: "Reserva", constraintName: "FKA49CA498119B0924", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "idSocio", referencedTableName: "Socio", referencesUniqueColumn: "false")
	}

	changeSet(author: "julio (generated)", id: "1348359843026-9") {
		createIndex(indexName: "FKB7C8A31F10D0464E", tableName: "Prestamo") {
			column(name: "idLibro")
		}
	}

	changeSet(author: "julio (generated)", id: "1348359843026-10") {
		createIndex(indexName: "FKB7C8A31F119B0924", tableName: "Prestamo") {
			column(name: "idSocio")
		}
	}

	changeSet(author: "julio (generated)", id: "1348359843026-11") {
		createIndex(indexName: "FKA49CA49810D0464E", tableName: "Reserva") {
			column(name: "idLibro")
		}
	}

	changeSet(author: "julio (generated)", id: "1348359843026-12") {
		createIndex(indexName: "FKA49CA498119B0924", tableName: "Reserva") {
			column(name: "idSocio")
		}
	}

	changeSet(author: "julio (generated)", id: "1348359843026-13") {
		createIndex(indexName: "email_unique_1348359842866", tableName: "Socio", unique: "true") {
			column(name: "email")
		}
	}
}
