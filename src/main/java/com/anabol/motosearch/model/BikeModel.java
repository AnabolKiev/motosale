package com.anabol.motosearch.model;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;

@Entity
@Table(name = "Model")
public class BikeModel {
    @JsonView(Views.AdminUi.class)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false, precision = 5, scale = 0)
    private Long id;
    @JsonView(Views.AdminUi.class)
    @Column(name = "Name", nullable = false, length = 100)
    private String name;
    @JsonView(Views.AdminUi.class)
    @Column(name = "Year")
    private Integer year;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ManufacturerId", nullable = false)
    private Manufacturer manufacturer;
    @Transient
    private Long manufacturerId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CategoryId")
    private Category category;
    @Transient
    private Long categoryId;
    @Column(name = "boreStroke", length = 30)
    private String boreStroke;
    @Column(name = "Compression", length = 10)
    private String compression;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CoolingTypeId")
    private CoolingType coolingType;
    @Transient
    private Long coolingTypeId;
    @Column(name = "Displacement")
    private Float displacement;
    @Column(name = "Engine", length = 255)
    private String engine;
    @Column(name = "EngineEng", length = 255)
    private String engineEng;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EngineTypeId")
    private EngineType engineType;
    @Transient
    private Long engineTypeId;
    @Column(name = "Lubrications", length = 255)
    private String lubrications;
    @Column(name = "LubricationsEng", length = 255)
    private String lubricationsEng;
    @Column(name = "MaxRPM")
    private Integer maxRPM;
    @Column(name = "OilCapacity")
    private Float oilCapacity;
    @Column(name = "ValvePerCylinder")
    private Integer valverPerCylinder;
    @Column(name = "Frame", length = 255)
    private String frame;
    @Column(name = "FrameEng", length = 255)
    private String frameEng;
    @Column(name = "Gearbox", length = 30)
    private String gearbox;
    @Column(name = "GearboxEng", length = 30)
    private String gearboxEng;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FinalDriveTypeId")
    private FinalDriveType finalDriveType;
    @Transient
    private Long finalDriveTypeId;
    @Column(name = "Clutch", length = 255)
    private String clutch;
    @Column(name = "ClutchEng", length = 255)
    private String clutchEng;
    @Column(name = "Height")
    private Integer height;
    @Column(name = "Length")
    private Integer length;
    @Column(name = "Width")
    private Integer width;
    @Column(name = "DryWeight")
    private Float dryWeight;
    @Column(name = "WetWeight")
    private Float wetWeight;
    @Column(name = "Wheelbase")
    private Integer wheelbase;
    @Column(name = "Clearance")
    private Integer clearance;
    @Column(name = "Carrying", length = 255)
    private String carrying;
    @Column(name = "CarryingEng", length = 255)
    private String carryingEng;
    @Column(name = "SeatHeight")
    private Integer seatHeight;
    @Column(name = "AltSeatHeight")
    private Integer altSeatHeight;
    @Column(name = "Seat", length = 255)
    private String seat;
    @Column(name = "seatEng", length = 255)
    private String seatEng;
    @Column(name = "Power", length = 40)
    private String power;
    @Column(name = "Torque", length = 60)
    private String torque;
    @Column(name = "PowerWeight")
    private Float powerWeight;
    @Column(name = "TopSpeed")
    private Float topSpeed;
    @Column(name = "Acceleration100")
    private Float acceleration100;
    @Column(name = "Acceleration60_140")
    private Float acceleration60_140;
    @Column(name = "QuoterTime")
    private Float quoterTime;
    @Column(name = "Ignition", length = 255)
    private String ignition;
    @Column(name = "IgnitionEng", length = 255)
    private String ignitionEng;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StarterTypeId")
    private StarterType starterType;
    @Transient
    private Long starterTypeId;
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
    private Float co2;
    @Column(name = "FuelControl", length = 50)
    private String fuelControl;
    @Column(name = "FuelControlEng", length = 50)
    private String fuelControlEng;
    @Column(name = "FuelSystem", length = 300)
    private String fuelSystem;
    @Column(name = "FuelSystemEng", length = 300)
    private String fuelSystemEng;
    @Column(name = "FuelCapacity")
    private Float fuelCapacity;
    @Column(name = "ReserveFuel")
    private Float reserveFuel;
    @Column(name = "Consumption")
    private Float consumption;
    @Column(name = "FrontBrakesDiameter")
    private Integer frontBrakesDiameter;
    @Column(name = "FrontBrakes", length = 255)
    private String frontBrakes;
    @Column(name = "FrontBrakesEng", length = 255)
    private String frontBrakesEng;
    @Column(name = "RearBrakesDiameter")
    private Integer rearBrakesDiameter;
    @Column(name = "RearBrakes", length = 200)
    private String rearBrakes;
    @Column(name = "RearBrakesEng", length = 200)
    private String rearBrakesEng;
    @Column(name = "FrontWeightPerc")
    private Float frontWeightPerc;
    @Column(name = "FrontSuspension", length = 255)
    private String frontSuspension;
    @Column(name = "FrontSuspensionEng", length = 255)
    private String frontSuspensionEng;
    @Column(name = "FrontTravel")
    private Integer frontTravel;
    @Column(name = "RearWeightPerc")
    private Float rearWeightPerc;
    @Column(name = "RearSuspension", length = 255)
    private String rearSuspension;
    @Column(name = "RearSuspensionEng", length = 255)
    private String rearSuspensionEng;
    @Column(name = "RearTravel")
    private Integer rearTravel;
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
    private Float rake;
    @Column(name = "Trail")
    private Integer trail;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    @JsonIgnore
    public Long getManufacturerId() {
        return manufacturerId;
    }
    @JsonProperty
    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @JsonIgnore
    public Long getCategoryId() {
        return categoryId;
    }
    @JsonProperty
    public void setCategoryId(Long categoryId) {
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

    public CoolingType getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(CoolingType coolingType) {
        this.coolingType = coolingType;
    }
    @JsonIgnore
    public Long getCoolingTypeId() {
        return coolingTypeId;
    }
    @JsonProperty
    public void setCoolingTypeId(Long coolingTypeId) {
        this.coolingTypeId = coolingTypeId;
    }

    public Float getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Float displacement) {
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

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
    @JsonIgnore
    public Long getEngineTypeId() {
        return engineTypeId;
    }
    @JsonProperty
    public void setEngineTypeId(Long engineTypeId) {
        this.engineTypeId = engineTypeId;
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

    public Integer getMaxRPM() {
        return maxRPM;
    }

    public void setMaxRPM(Integer maxRPM) {
        this.maxRPM = maxRPM;
    }

    public Float getOilCapacity() {
        return oilCapacity;
    }

    public void setOilCapacity(Float oilCapacity) {
        this.oilCapacity = oilCapacity;
    }

    public Integer getValverPerCylinder() {
        return valverPerCylinder;
    }

    public void setValverPerCylinder(Integer valverPerCylinder) {
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

    public FinalDriveType getFinalDriveType() {
        return finalDriveType;
    }

    public void setFinalDriveType(FinalDriveType finalDriveType) {
        this.finalDriveType = finalDriveType;
    }
    @JsonIgnore
    public Long getFinalDriveTypeId() {
        return finalDriveTypeId;
    }
    @JsonProperty
    public void setFinalDriveTypeId(Long finalDriveTypeId) {
        this.finalDriveTypeId = finalDriveTypeId;
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Float getDryWeight() {
        return dryWeight;
    }

    public void setDryWeight(Float dryWeight) {
        this.dryWeight = dryWeight;
    }

    public Float getWetWeight() {
        return wetWeight;
    }

    public void setWetWeight(Float wetWeight) {
        this.wetWeight = wetWeight;
    }

    public Integer getWheelbase() {
        return wheelbase;
    }

    public void setWheelbase(Integer wheelbase) {
        this.wheelbase = wheelbase;
    }

    public Integer getClearance() {
        return clearance;
    }

    public void setClearance(Integer clearance) {
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

    public Integer getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(Integer seatHeight) {
        this.seatHeight = seatHeight;
    }

    public Integer getAltSeatHeight() {
        return altSeatHeight;
    }

    public void setAltSeatHeight(Integer altSeatHeight) {
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

    public Float getPowerWeight() {
        return powerWeight;
    }

    public void setPowerWeight(Float powerWeight) {
        this.powerWeight = powerWeight;
    }

    public Float getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(Float topSpeed) {
        this.topSpeed = topSpeed;
    }

    public Float getAcceleration100() {
        return acceleration100;
    }

    public void setAcceleration100(Float acceleration100) {
        this.acceleration100 = acceleration100;
    }

    public Float getAcceleration60_140() {
        return acceleration60_140;
    }

    public void setAcceleration60_140(Float acceleration60_140) {
        this.acceleration60_140 = acceleration60_140;
    }

    public Float getQuoterTime() {
        return quoterTime;
    }

    public void setQuoterTime(Float quoterTime) {
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

    public StarterType getStarterType() {
        return starterType;
    }

    public void setStarterType(StarterType starterType) {
        this.starterType = starterType;
    }
    @JsonIgnore
    public Long getStarterTypeId() {
        return starterTypeId;
    }
    @JsonProperty
    public void setStarterTypeId(Long starterTypeId) {
        this.starterTypeId = starterTypeId;
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

    public Float getCo2() {
        return co2;
    }

    public void setCo2(Float co2) {
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

    public Float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Float getReserveFuel() {
        return reserveFuel;
    }

    public void setReserveFuel(Float reserveFuel) {
        this.reserveFuel = reserveFuel;
    }

    public Float getConsumption() {
        return consumption;
    }

    public void setConsumption(Float consumption) {
        this.consumption = consumption;
    }

    public Integer getFrontBrakesDiameter() {
        return frontBrakesDiameter;
    }

    public void setFrontBrakesDiameter(Integer frontBrakesDiameter) {
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

    public Integer getRearBrakesDiameter() {
        return rearBrakesDiameter;
    }

    public void setRearBrakesDiameter(Integer rearBrakesDiameter) {
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

    public Float getFrontWeightPerc() {
        return frontWeightPerc;
    }

    public void setFrontWeightPerc(Float frontWeightPerc) {
        this.frontWeightPerc = frontWeightPerc;
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

    public Integer getFrontTravel() {
        return frontTravel;
    }

    public void setFrontTravel(Integer frontTravel) {
        this.frontTravel = frontTravel;
    }

    public Float getRearWeightPerc() {
        return rearWeightPerc;
    }

    public void setRearWeightPerc(Float rearWeightPerc) {
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

    public Integer getRearTravel() {
        return rearTravel;
    }

    public void setRearTravel(Integer rearTravel) {
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

    public Float getRake() {
        return rake;
    }

    public void setRake(Float rake) {
        this.rake = rake;
    }

    public Integer getTrail() {
        return trail;
    }

    public void setTrail(Integer trail) {
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
