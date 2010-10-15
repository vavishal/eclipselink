/*******************************************************************************
 * Copyright (c) 1998, 2010 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     06/16/2009-2.0 Guy Pelletier 
 *       - 277039: JPA 2.0 Cache Usage Settings
 ******************************************************************************/
package org.eclipse.persistence.testing.models.jpa.cacheable;

import static javax.persistence.GenerationType.TABLE;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity(name="JPA_CACHEABLE_FALSE")
@Cacheable(false)
public class CacheableFalseEntity {
    private int id;
    List<CacheableFalseDetail> details = new ArrayList<CacheableFalseDetail>();
    
    public CacheableFalseEntity() {}
    
    @Id
    @GeneratedValue(strategy=TABLE, generator="CACHEABLE_TABLE_GENERATOR")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "JPA_CACHEABLE_FALSE_TO_DETAIL",
            joinColumns=@JoinColumn(name="ENTITY_ID"),
            inverseJoinColumns=@JoinColumn(name="DETAIL_ID")
    )
    @OrderColumn(name = "IND")
    public List<CacheableFalseDetail> getDetails() {
        return details;
    }

    public void setDetails(List<CacheableFalseDetail> details) {
        this.details = details;
    }
}
