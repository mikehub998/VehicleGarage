package com.mb.persistence.domain;

public class Vehicle {

	private Long id;
	private String vehicleMake;
	private String vehicleModel;
    private double engineSize;
    private String transmission;
    private int cost;

	public Vehicle(String vehicleMake, String vehicleModel, double engineSize, String transmission, int cost) {
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
        this.engineSize = engineSize;
        this.transmission = transmission;
        this.cost = cost;
	}

	public Vehicle(Long id, String vehicleMake, String vehicleModel, double engineSize, String transmission, int cost) {
		this.id = id;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
        this.engineSize  = engineSize;
        this.transmission = transmission;
        this.cost = cost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getvehicleMake() {
		return vehicleMake;
	}

	public void setvehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getvehicleModel() {
		return vehicleModel;
	}

	public void setvehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

    public double getengineSize() {
        return engineSize;
    }

    public void setengineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public String gettansmission() {
        return transmission;
    }

    public void settransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getcost() {
        return cost;
    }

    public void setcost(int cost) {
        this.cost = cost;
    }


	@Override
	public String toString() {
		return "id:" + id + " Vehicle make:" + vehicleMake + " Vehicle model:" + vehicleModel + "Engine size" + engineSize + 
        "Transmission" + transmission + "cost" + cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vehicleMake == null) ? 0 : vehicleMake.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vehicleModel == null) ? 0 : vehicleModel.hashCode());
        result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (getvehicleMake() == null) {
			if (other.getvehicleMake() != null)
				return false;
		} else if (!getvehicleMake().equals(other.getvehicleMake()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vehicleModel == null) {
			if (other.vehicleModel != null)
				return false;
		} else if (!vehicleModel.equals(other.vehicleModel))
			return false;
        if (transmission == null) {
            if (other.transmission != null)
                return false;
        } else if (!transmission.equals(other.transmission))
            return false;

		return true;
	}

}
