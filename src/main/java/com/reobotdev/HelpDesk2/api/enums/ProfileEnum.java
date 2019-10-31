package com.reobotdev.HelpDesk2.api.enums;

public enum ProfileEnum {

		ADMIN(1, "ROLE_ADMIN"),
		CUSTOMER(2, "ROLE_CUSTOMER"),
	    TECNICIAN(3, "ROLE_TECNICIAN");
		

		private int cod;
		private String descricao;

		private ProfileEnum(int cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;
		}

		public int getCod() {
			return cod;
		}

		public String getDescricao () {
			return descricao;
		}

		public static ProfileEnum toEnum(Integer cod) {

			if (cod == null) {
				return null;
			}

			for (ProfileEnum  x : ProfileEnum.values()) {
				if (cod.equals(x.getCod())) {
					return x;
				}
			}

			throw new IllegalArgumentException("Id inválido: " + cod);
		}

	}