/*
 * Copyright (c) 1998, 2024 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.oxm.mappings.compositeobject.nillable;

public class Team2 {
    public static final int DEFAULT_ID = 123;

    // Factory method
    public static Team2 getInstance() {
        return new Team2(DEFAULT_ID, new Employee2(), "Eng");
    }

    private int id;
    private Employee2 manager;
    private String name;

    private boolean isSetManager = false;

    public Team2() {
        super();
    }

    public Team2(int id) {
        super();
        this.id = id;
    }

    public Team2(int id, Employee2 manager, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    // override default equals
    public boolean equals(Object object) {
      try {
          Team2 team = (Team2) object;
          if(this.getId() != team.getId()) {
              return false;
          }
          if(this.isSetManager() != team.isSetManager()) {
              return false;
          }
          if(this.getManager() != team.getManager()) {
            if(this.getManager() == null) {
                return false;
            }
            if(!this.getManager().equals(team.getManager())) {
                return false;
            }
          }
          if(this.getName() != team.getName()) {
            if(this.getName() == null) {
                return false;
            }
              return this.getName().equals(team.getName());
          }
          return true;
      } catch(ClassCastException e) {
          return false;
      }
    }

    public int getId() {
        return id;
    }

    public Employee2 getManager() {
        return manager;
    }

    public String getName() {
        return name;
    }

    public boolean isSetManager() {
        return isSetManager;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManager(Employee2 manager) {
        // no unset for now
        isSetManager = true;
        this.manager = manager;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder aBuffer = new StringBuilder();
        aBuffer.append("Team(id=");
        aBuffer.append(getId());
        aBuffer.append(", manager=");
        aBuffer.append(getManager());
        aBuffer.append(", isSetManager=");
        aBuffer.append(isSetManager());
        aBuffer.append(", name=");
        aBuffer.append(getName());
        aBuffer.append(")");
        return aBuffer.toString();
    }

}

