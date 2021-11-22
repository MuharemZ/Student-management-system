package se.iths.entity;
import javax.persistence.*;
    @Entity
    public class Subject {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String Math;
        private String History;
        private String Chemistry;
        private String Science;
        private String Technology;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMath() {
            return Math;
        }

        public void setMath(String math) {
            Math = math;
        }

        public String getHistory() {
            return History;
        }

        public void setHistory(String history) {
            History = history;
        }

        public String getChemistry() {
            return Chemistry;
        }

        public void setChemistry(String chemistry) {
            Chemistry = chemistry;
        }

        public String getScience() {
            return Science;
        }

        public void setScience(String science) {
            Science = science;
        }

        public String getTechnology() {
            return Technology;
        }

        public void setTechnology(String technology) {
            Technology = technology;
        }


    }
