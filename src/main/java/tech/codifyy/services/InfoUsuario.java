package tech.codifyy.services;

public class InfoUsuario {
        private Integer _id;
        private String name, firstLetter, email;

        public InfoUsuario(){
        }

        public InfoUsuario(Integer _id, String name, String firstLetter, String email) {
                this._id = _id;
                this.name = name;
                this.firstLetter = firstLetter;
                this.email = email;
        }

        public Integer get_id() {
                return _id;
        }

        public void set_id(Integer _id) {
                this._id = _id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getFirstLetter() {
                return firstLetter;
        }

        public void setFirstLetter(String firstLetter) {
                this.firstLetter = firstLetter;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}
