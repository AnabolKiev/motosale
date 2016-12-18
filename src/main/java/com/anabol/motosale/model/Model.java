package com.anabol.motosale.model;

import javax.persistence.*;

@Entity
@Table(name = "Model")
public class Model {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false, precision = 5, scale = 0)
    private Long id;
    @Column(name = "Name", nullable = false, length = 100)
    private String name;
    @Column(name = "Year")
    private int year;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANUFACTURERID", nullable = false)
    private Manufacturer manufacturer;
    @Column(name = "CategoryId")
    private int categoryId;
    @Column(name = "boreStroke", length = 30)
    private String boreStroke;
    @Column(name = "Compression", length = 10)
    private String compression;
    @Column(name = "CoolingId")
    private int coolingID;
    @Column(name = "Displacement")
    private float displacement;
    @Column(name = "Engine", length = 255)
    private String engine;
    @Column(name = "EngineEng", length = 255)
    private String engineEng;
    @Column(name = "EngineTypeId")
    private int enginetypeId;
    @Column(name = "Lubrications", length = 255)
    private String lubrications;
    @Column(name = "LubricationsEng", length = 255)
    private String lubricationsEng;
    @Column(name = "MaxRPM")
    private int maxRPM;
    @Column(name = "OilCapacity")
    private float oilCapacity;
    @Column(name = "ValvePerCylinder")
    private int valverPerCylinder;
    @Column(name = "Frame", length = 255)
    private String frame;
    @Column(name = "FrameEng", length = 255)
    private String frameEng;
    @Column(name = "Gearbox", length = 30)
    private String gearbox;
    @Column(name = "GearboxEng", length = 30)
    private String gearboxEng;
    @Column(name = "FinalDriveId")
    private int finaldriveId;
    @Column(name = "Clutch", length = 255)
    private String clutch;
    @Column(name = "ClutchEng", length = 255)
    private String clutchEng;
    @Column(name = "Height")
    private int height;
    @Column(name = "Length")
    private int length;
    @Column(name = "Width")
    private int width;
    @Column(name = "DryWeight")
    private float dryWeight;
    @Column(name = "WetWeight")
    private float wetWeight;
    @Column(name = "Wheelbase")
    private int wheelbase;
    @Column(name = "Clearance")
    private int clearance;
    @Column(name = "Carrying", length = 255)
    private String carrying;
    @Column(name = "CarryingEng", length = 255)
    private String carryingEng;
    @Column(name = "SeatHeight")
    private int seatHeight;
    @Column(name = "AltSeatHeight")
    private int altSeatHeight;
    @Column(name = "Seat", length = 255)
    private String seat;
    @Column(name = "seatEng", length = 255)
    private String seatEng;
    @Column(name = "Power", length = 40)
    private String power;
    @Column(name = "Torque", length = 60)
    private String torque;
    @Column(name = "PowerWeight")
    private float powerWeight;
    @Column(name = "TopSpeed")
    private float topSpeed;
    @Column(name = "Acceleration100")
    private float acceleration100;
    @Column(name = "Acceleration60_140")
    private float acceleration60_140;
    @Column(name = "QuoterTime")
    private float quoterTime;
    @Column(name = "Ignition", length = 255)
    private String ignition;
    @Column(name = "IgnitionEng", length = 255)
    private String ignitionEng;
    @Column(name = "StarterId")
    private int starterID;
    @Column(name = "Light", length = 255)
    private String light;
    @Column(name = "LightEng", length = 255)
    private String lightEng;
    @Column(name = "Emission", length = 255)
    private String emission;
    @Column(name = "EmissionEng", length = 255)
    private String emissionEng;
    @Column(name = "Exhaust", length = 255)
    private String exhaust;
    @Column(name = "ExhaustEng", length = 255)
    private String exhaustEng;
    @Column(name = "CO2")
    private float co2;
    @Column(name = "FuelControl", length = 50)
    private String fuelControl;
    @Column(name = "FuelControlEng", length = 50)
    private String fuelControlEng;
    @Column(name = "FuelSystem", length = 300)
    private String fuelSystem;
    @Column(name = "FuelSystemEng", length = 300)
    private String fuelSystemEng;
    @Column(name = "FuelCapacity")
    private float fuelCapacity;
    @Column(name = "ReserveFuel")
    private float reserveFuel;
    @Column(name = "Consumption")
    private float consumtion;
    @Column(name = "FrontBrakesDiameter")
    private int frontBrakesDiameter;
    @Column(name = "FrontBrakes", length = 255)
    private String frontBrakes;
    @Column(name = "FrontBrakesEng", length = 255)
    private String frontBrakesEng;
    @Column(name = "RearBrakesDiameter")
    private int rearBrakesDiameter;
    @Column(name = "RearBrakes", length = 200)
    private String rearBrakes;
    @Column(name = "RearBrakesEng", length = 200)
    private String rearBrakesEng;
    @Column(name = "FrontWeightPerc")
    private float fronWeightPerc;
    @Column(name = "FrontSuspension", length = 255)
    private String frontSuspension;
    @Column(name = "FrontSuspensionEng", length = 255)
    private String frontSuspensionEng;
    @Column(name = "FrontTravel")
    private int frontTravel;
    @Column(name = "RearWeightPerc")
    private float rearWeightPerc;
    @Column(name = "RearSuspension", length = 255)
    private String rearSuspension;
    @Column(name = "RearSuspensionEng", length = 255)
    private String rearSuspensionEng;
    @Column(name = "RearTravel")
    private int rearTravel;
    @Column(name = "FrontTyre", length = 30)
    private String frontTyre;
    @Column(name = "FrontTyreEng", length = 30)
    private String frontTyreEng;
    @Column(name = "RearTyre", length = 30)
    private String rearTyre;
    @Column(name = "RearTyreEng", length = 30)
    private String rearTyreEng;
    @Column(name = "Wheels", length = 255)
    private String wheels;
    @Column(name = "WheelsEng", length = 255)
    private String wheelsEng;
    @Column(name = "Rake")
    private float rake;
    @Column(name = "Trail")
    private int trail;
    @Column(name = "Driveline", length = 255)
    private String driveline;
    @Column(name = "DrivelineEng", length = 255)
    private String drivelineEng;
    @Column(name = "Electrical", length = 255)
    private String electrical;
    @Column(name = "ElectricalEng", length = 255)
    private String electricalEng;
    @Column(name = "Instruments", length = 512)
    private String instruments;
    @Column(name = "InstrumentsEng", length = 512)
    private String instrumentsEng;
    @Column(name = "Modifications", length = 2048)
    private String modifications;
    @Column(name = "ModificationsEng", length = 2048)
    private String modificationsEng;
    @Column(name = "Price", length = 15)
    private String price;
    @Column(name = "Colors", length = 300)
    private String colors;
    @Column(name = "ColorsEng", length = 300)
    private String colorsEng;
    @Column(name = "Comments", length = 2048)
    private String comments;
    @Column(name = "CommentsEng", length = 2048)
    private String commentsEng;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getBoreStroke() {
        return boreStroke;
    }

    public void setBoreStroke(String boreStroke) {
        this.boreStroke = boreStroke;
    }

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public int getCoolingID() {
        return coolingID;
    }

    public void setCoolingID(int coolingID) {
        this.coolingID = coolingID;
    }

    public float getDisplacement() {
        return displacement;
    }

    public void setDisplacement(float displacement) {
        this.displacement = displacement;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEngineEng() {
        return engineEng;
    }

    public void setEngineEng(String engineEng) {
        this.engineEng = engineEng;
    }

    public int getEnginetypeId() {
        return enginetypeId;
    }

    public void setEnginetypeId(int enginetypeId) {
        this.enginetypeId = enginetypeId;
    }

    public String getLubrications() {
        return lubrications;
    }

    public void setLubrications(String lubrications) {
        this.lubrications = lubrications;
    }

    public String getLubricationsEng() {
        return lubricationsEng;
    }

    public void setLubricationsEng(String lubricationsEng) {
        this.lubricationsEng = lubricationsEng;
    }

    public int getMaxRPM() {
        return maxRPM;
    }

    public void setMaxRPM(int maxRPM) {
        this.maxRPM = maxRPM;
    }

    public float getOilCapacity() {
        return oilCapacity;
    }

    public void setOilCapacity(float oilCapacity) {
        this.oilCapacity = oilCapacity;
    }

    public int getValverPerCylinder() {
        return valverPerCylinder;
    }

    public void setValverPerCylinder(int valverPerCylinder) {
        this.valverPerCylinder = valverPerCylinder;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getFrameEng() {
        return frameEng;
    }

    public void setFrameEng(String frameEng) {
        this.frameEng = frameEng;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getGearboxEng() {
        return gearboxEng;
    }

    public void setGearboxEng(String gearboxEng) {
        this.gearboxEng = gearboxEng;
    }

    public int getFinaldriveId() {
        return finaldriveId;
    }

    public void setFinaldriveId(int finaldriveId) {
        this.finaldriveId = finaldriveId;
    }

    public String getClutch() {
        return clutch;
    }

    public void setClutch(String clutch) {
        this.clutch = clutch;
    }

    public String getClutchEng() {
        return clutchEng;
    }

    public void setClutchEng(String clutchEng) {
        this.clutchEng = clutchEng;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getDryWeight() {
        return dryWeight;
    }

    public void setDryWeight(float dryWeight) {
        this.dryWeight = dryWeight;
    }

    public float getWetWeight() {
        return wetWeight;
    }

    public void setWetWeight(float wetWeight) {
        this.wetWeight = wetWeight;
    }

    public int getWheelbase() {
        return wheelbase;
    }

    public void setWheelbase(int wheelbase) {
        this.wheelbase = wheelbase;
    }

    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

    public String getCarrying() {
        return carrying;
    }

    public void setCarrying(String carrying) {
        this.carrying = carrying;
    }

    public String getCarryingEng() {
        return carryingEng;
    }

    public void setCarryingEng(String carryingEng) {
        this.carryingEng = carryingEng;
    }

    public int getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

    public int getAltSeatHeight() {
        return altSeatHeight;
    }

    public void setAltSeatHeight(int altSeatHeight) {
        this.altSeatHeight = altSeatHeight;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getSeatEng() {
        return seatEng;
    }

    public void setSeatEng(String seatEng) {
        this.seatEng = seatEng;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    public float getPowerWeight() {
        return powerWeight;
    }

    public void setPowerWeight(float powerWeight) {
        this.powerWeight = powerWeight;
    }

    public float getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(float topSpeed) {
        this.topSpeed = topSpeed;
    }

    public float getAcceleration100() {
        return acceleration100;
    }

    public void setAcceleration100(float acceleration100) {
        this.acceleration100 = acceleration100;
    }

    public float getAcceleration60_140() {
        return acceleration60_140;
    }

    public void setAcceleration60_140(float acceleration60_140) {
        this.acceleration60_140 = acceleration60_140;
    }

    public float getQuoterTime() {
        return quoterTime;
    }

    public void setQuoterTime(float quoterTime) {
        this.quoterTime = quoterTime;
    }

    public String getIgnition() {
        return ignition;
    }

    public void setIgnition(String ignition) {
        this.ignition = ignition;
    }

    public String getIgnitionEng() {
        return ignitionEng;
    }

    public void setIgnitionEng(String ignitionEng) {
        this.ignitionEng = ignitionEng;
    }

    public int getStarterID() {
        return starterID;
    }

    public void setStarterID(int starterID) {
        this.starterID = starterID;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getLightEng() {
        return lightEng;
    }

    public void setLightEng(String lightEng) {
        this.lightEng = lightEng;
    }

    public String getEmission() {
        return emission;
    }

    public void setEmission(String emission) {
        this.emission = emission;
    }

    public String getEmissionEng() {
        return emissionEng;
    }

    public void setEmissionEng(String emissionEng) {
        this.emissionEng = emissionEng;
    }

    public String getExhaust() {
        return exhaust;
    }

    public void setExhaust(String exhaust) {
        this.exhaust = exhaust;
    }

    public String getExhaustEng() {
        return exhaustEng;
    }

    public void setExhaustEng(String exhaustEng) {
        this.exhaustEng = exhaustEng;
    }

    public float getCo2() {
        return co2;
    }

    public void setCo2(float co2) {
        this.co2 = co2;
    }

    public String getFuelControl() {
        return fuelControl;
    }

    public void setFuelControl(String fuelControl) {
        this.fuelControl = fuelControl;
    }

    public String getFuelControlEng() {
        return fuelControlEng;
    }

    public void setFuelControlEng(String fuelControlEng) {
        this.fuelControlEng = fuelControlEng;
    }

    public String getFuelSystem() {
        return fuelSystem;
    }

    public void setFuelSystem(String fuelSystem) {
        this.fuelSystem = fuelSystem;
    }

    public String getFuelSystemEng() {
        return fuelSystemEng;
    }

    public void setFuelSystemEng(String fuelSystemEng) {
        this.fuelSystemEng = fuelSystemEng;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public float getReserveFuel() {
        return reserveFuel;
    }

    public void setReserveFuel(float reserveFuel) {
        this.reserveFuel = reserveFuel;
    }

    public float getConsumtion() {
        return consumtion;
    }

    public void setConsumtion(float consumtion) {
        this.consumtion = consumtion;
    }

    public int getFrontBrakesDiameter() {
        return frontBrakesDiameter;
    }

    public void setFrontBrakesDiameter(int frontBrakesDiameter) {
        this.frontBrakesDiameter = frontBrakesDiameter;
    }

    public String getFrontBrakes() {
        return frontBrakes;
    }

    public void setFrontBrakes(String frontBrakes) {
        this.frontBrakes = frontBrakes;
    }

    public String getFrontBrakesEng() {
        return frontBrakesEng;
    }

    public void setFrontBrakesEng(String frontBrakesEng) {
        this.frontBrakesEng = frontBrakesEng;
    }

    public int getRearBrakesDiameter() {
        return rearBrakesDiameter;
    }

    public void setRearBrakesDiameter(int rearBrakesDiameter) {
        this.rearBrakesDiameter = rearBrakesDiameter;
    }

    public String getRearBrakes() {
        return rearBrakes;
    }

    public void setRearBrakes(String rearBrakes) {
        this.rearBrakes = rearBrakes;
    }

    public String getRearBrakesEng() {
        return rearBrakesEng;
    }

    public void setRearBrakesEng(String rearBrakesEng) {
        this.rearBrakesEng = rearBrakesEng;
    }

    public float getFronWeightPerc() {
        return fronWeightPerc;
    }

    public void setFronWeightPerc(float fronWeightPerc) {
        this.fronWeightPerc = fronWeightPerc;
    }

    public String getFrontSuspension() {
        return frontSuspension;
    }

    public void setFrontSuspension(String frontSuspension) {
        this.frontSuspension = frontSuspension;
    }

    public String getFrontSuspensionEng() {
        return frontSuspensionEng;
    }

    public void setFrontSuspensionEng(String frontSuspensionEng) {
        this.frontSuspensionEng = frontSuspensionEng;
    }

    public int getFrontTravel() {
        return frontTravel;
    }

    public void setFrontTravel(int frontTravel) {
        this.frontTravel = frontTravel;
    }

    public float getRearWeightPerc() {
        return rearWeightPerc;
    }

    public void setRearWeightPerc(float rearWeightPerc) {
        this.rearWeightPerc = rearWeightPerc;
    }

    public String getRearSuspension() {
        return rearSuspension;
    }

    public void setRearSuspension(String rearSuspension) {
        this.rearSuspension = rearSuspension;
    }

    public String getRearSuspensionEng() {
        return rearSuspensionEng;
    }

    public void setRearSuspensionEng(String rearSuspensionEng) {
        this.rearSuspensionEng = rearSuspensionEng;
    }

    public int getRearTravel() {
        return rearTravel;
    }

    public void setRearTravel(int rearTravel) {
        this.rearTravel = rearTravel;
    }

    public String getFrontTyre() {
        return frontTyre;
    }

    public void setFrontTyre(String frontTyre) {
        this.frontTyre = frontTyre;
    }

    public String getFrontTyreEng() {
        return frontTyreEng;
    }

    public void setFrontTyreEng(String frontTyreEng) {
        this.frontTyreEng = frontTyreEng;
    }

    public String getRearTyre() {
        return rearTyre;
    }

    public void setRearTyre(String rearTyre) {
        this.rearTyre = rearTyre;
    }

    public String getRearTyreEng() {
        return rearTyreEng;
    }

    public void setRearTyreEng(String rearTyreEng) {
        this.rearTyreEng = rearTyreEng;
    }

    public String getWheels() {
        return wheels;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public String getWheelsEng() {
        return wheelsEng;
    }

    public void setWheelsEng(String wheelsEng) {
        this.wheelsEng = wheelsEng;
    }

    public float getRake() {
        return rake;
    }

    public void setRake(float rake) {
        this.rake = rake;
    }

    public int getTrail() {
        return trail;
    }

    public void setTrail(int trail) {
        this.trail = trail;
    }

    public String getDriveline() {
        return driveline;
    }

    public void setDriveline(String driveline) {
        this.driveline = driveline;
    }

    public String getDrivelineEng() {
        return drivelineEng;
    }

    public void setDrivelineEng(String drivelineEng) {
        this.drivelineEng = drivelineEng;
    }

    public String getElectrical() {
        return electrical;
    }

    public void setElectrical(String electrical) {
        this.electrical = electrical;
    }

    public String getElectricalEng() {
        return electricalEng;
    }

    public void setElectricalEng(String electricalEng) {
        this.electricalEng = electricalEng;
    }

    public String getInstruments() {
        return instruments;
    }

    public void setInstruments(String instruments) {
        this.instruments = instruments;
    }

    public String getInstrumentsEng() {
        return instrumentsEng;
    }

    public void setInstrumentsEng(String instrumentsEng) {
        this.instrumentsEng = instrumentsEng;
    }

    public String getModifications() {
        return modifications;
    }

    public void setModifications(String modifications) {
        this.modifications = modifications;
    }

    public String getModificationsEng() {
        return modificationsEng;
    }

    public void setModificationsEng(String modificationsEng) {
        this.modificationsEng = modificationsEng;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getColorsEng() {
        return colorsEng;
    }

    public void setColorsEng(String colorsEng) {
        this.colorsEng = colorsEng;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCommentsEng() {
        return commentsEng;
    }

    public void setCommentsEng(String commentsEng) {
        this.commentsEng = commentsEng;
    }
}
