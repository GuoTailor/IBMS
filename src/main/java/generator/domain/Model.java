package generator.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * null
 * @TableName model
 */
public class Model implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 模型名称
     */
    private String name;

    /**
     * 所属楼宇
     */
    private Integer buildingId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * IotId
     */
    private String iotId;

    /**
     * ProductKey
     */
    private String productKey;

    /**
     * DeviceName
     */
    private String deviceName;

    private static final long serialVersionUID = 1L;

    /**
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 模型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 模型名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 所属楼宇
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * 所属楼宇
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * IotId
     */
    public String getIotId() {
        return iotId;
    }

    /**
     * IotId
     */
    public void setIotId(String iotId) {
        this.iotId = iotId;
    }

    /**
     * ProductKey
     */
    public String getProductKey() {
        return productKey;
    }

    /**
     * ProductKey
     */
    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    /**
     * DeviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * DeviceName
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Model other = (Model) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIotId() == null ? other.getIotId() == null : this.getIotId().equals(other.getIotId()))
            && (this.getProductKey() == null ? other.getProductKey() == null : this.getProductKey().equals(other.getProductKey()))
            && (this.getDeviceName() == null ? other.getDeviceName() == null : this.getDeviceName().equals(other.getDeviceName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIotId() == null) ? 0 : getIotId().hashCode());
        result = prime * result + ((getProductKey() == null) ? 0 : getProductKey().hashCode());
        result = prime * result + ((getDeviceName() == null) ? 0 : getDeviceName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", createTime=").append(createTime);
        sb.append(", iotId=").append(iotId);
        sb.append(", productKey=").append(productKey);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}