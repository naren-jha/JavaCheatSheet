package com.njha;

public class EqualsAndHashcode {

    class X {
        Integer f, f2;
        
        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj == this) return true;
            
            //if (!(obj instanceof X)) return false;
            if (getClass() != obj.getClass()) return false;
            
            X x2 = (X) obj;
            return this.f == x2.f && this.f2 == x2.f2;
        }
        
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 89*hash + f.hashCode();
            hash = 89*hash + f2.hashCode();
            return hash;
        }
        
        @Override
        public String toString() {
            return String.format("f = %d, f2 = %d", f, f2);
        }
    }
    
}
