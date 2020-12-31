package com.njha;

public class EqualsAndHashcode {

    class X {
        Integer f1, f2;
        
        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj == this) return true;
            
            if (this.getClass() != obj.getClass()) return false;
            
            X x2 = (X) obj;
            return this.f1 == x2.f1 && this.f2 == x2.f2;
        }
        
        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + (f1 != null ? f1.hashCode() : 0);
            hash = 31 * hash + (f2 != null ? f2.hashCode() : 0);
            return hash;
        }
        
        @Override
        public String toString() {
            return String.format("f = %d, f2 = %d", f1, f2);
        }
    }
    
}
