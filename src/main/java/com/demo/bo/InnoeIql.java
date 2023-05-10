package com.demo.bo;

/**
 * @author lwh
 * @description:
 * @date 2023/3/31 14:49
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InnoeIql {
    private String whereClause;
    private String orderClause;
    private String fl;
    private Set<String> whereTableSet;
    private Set<String> orderTableSet;
    private Set<String> flTableSet;
    private Set<String> allTableSet;

    public Set<String> getAllTableSet() {
        Set<String> allTable = new HashSet();
        if (null != this.whereTableSet && !this.whereTableSet.isEmpty()) {
            allTable.addAll(this.whereTableSet);
        }

        if (null != this.orderTableSet && !this.orderTableSet.isEmpty()) {
            allTable.addAll(this.orderTableSet);
        }

        if (null != this.flTableSet && !this.flTableSet.isEmpty()) {
            allTable.addAll(this.flTableSet);
        }

        allTable.removeAll(Collections.singleton((Object)null));
        return allTable;
    }

    public InnoeIql() {
    }

    public String getWhereClause() {
        return this.whereClause;
    }

    public String getOrderClause() {
        return this.orderClause;
    }

    public String getFl() {
        return this.fl;
    }

    public Set<String> getWhereTableSet() {
        return this.whereTableSet;
    }

    public Set<String> getOrderTableSet() {
        return this.orderTableSet;
    }

    public Set<String> getFlTableSet() {
        return this.flTableSet;
    }

    public void setWhereClause(String whereClause) {
        this.whereClause = whereClause;
    }

    public void setOrderClause(String orderClause) {
        this.orderClause = orderClause;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public void setWhereTableSet(Set<String> whereTableSet) {
        this.whereTableSet = whereTableSet;
    }

    public void setOrderTableSet(Set<String> orderTableSet) {
        this.orderTableSet = orderTableSet;
    }

    public void setFlTableSet(Set<String> flTableSet) {
        this.flTableSet = flTableSet;
    }

    public void setAllTableSet(Set<String> allTableSet) {
        this.allTableSet = allTableSet;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof InnoeIql)) {
            return false;
        } else {
            InnoeIql other = (InnoeIql)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label95: {
                    Object this$whereClause = this.getWhereClause();
                    Object other$whereClause = other.getWhereClause();
                    if (this$whereClause == null) {
                        if (other$whereClause == null) {
                            break label95;
                        }
                    } else if (this$whereClause.equals(other$whereClause)) {
                        break label95;
                    }

                    return false;
                }

                Object this$orderClause = this.getOrderClause();
                Object other$orderClause = other.getOrderClause();
                if (this$orderClause == null) {
                    if (other$orderClause != null) {
                        return false;
                    }
                } else if (!this$orderClause.equals(other$orderClause)) {
                    return false;
                }

                Object this$fl = this.getFl();
                Object other$fl = other.getFl();
                if (this$fl == null) {
                    if (other$fl != null) {
                        return false;
                    }
                } else if (!this$fl.equals(other$fl)) {
                    return false;
                }

                label74: {
                    Object this$whereTableSet = this.getWhereTableSet();
                    Object other$whereTableSet = other.getWhereTableSet();
                    if (this$whereTableSet == null) {
                        if (other$whereTableSet == null) {
                            break label74;
                        }
                    } else if (this$whereTableSet.equals(other$whereTableSet)) {
                        break label74;
                    }

                    return false;
                }

                label67: {
                    Object this$orderTableSet = this.getOrderTableSet();
                    Object other$orderTableSet = other.getOrderTableSet();
                    if (this$orderTableSet == null) {
                        if (other$orderTableSet == null) {
                            break label67;
                        }
                    } else if (this$orderTableSet.equals(other$orderTableSet)) {
                        break label67;
                    }

                    return false;
                }

                Object this$flTableSet = this.getFlTableSet();
                Object other$flTableSet = other.getFlTableSet();
                if (this$flTableSet == null) {
                    if (other$flTableSet != null) {
                        return false;
                    }
                } else if (!this$flTableSet.equals(other$flTableSet)) {
                    return false;
                }

                Object this$allTableSet = this.getAllTableSet();
                Object other$allTableSet = other.getAllTableSet();
                if (this$allTableSet == null) {
                    if (other$allTableSet != null) {
                        return false;
                    }
                } else if (!this$allTableSet.equals(other$allTableSet)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof InnoeIql;
    }


}