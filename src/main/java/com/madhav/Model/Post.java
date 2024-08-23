    package com.madhav.Model;

    import org.springframework.data.mongodb.core.mapping.Document;

    import java.util.Arrays;
    @Document(collection = "Jobs")
    public class Post {
        private String job_profile;
        private String years_of_experience;
        private String[] skills;
        private int avg_salary_in_rupees;
        private String location;
        public Post() {
        }

        @Override
        public String toString() {
            return "Post{" +
                    "job_profile='" + job_profile + '\'' +
                    ", years_of_experience='" + years_of_experience + '\'' +
                    ", skills=" + Arrays.toString(skills) +
                    ", avg_salary_in_rupees=" + avg_salary_in_rupees +
                    ", location='" + location + '\'' +
                    '}';
        }

        public String getJob_profile() {
            return job_profile;
        }

        public void setJob_profile(String job_profile) {
            this.job_profile = job_profile;
        }

        public String getYears_of_experience() {
            return years_of_experience;
        }

        public void setYears_of_experience(String years_of_experience) {
            this.years_of_experience = years_of_experience;
        }

        public String[] getSkills() {
            return skills;
        }

        public void setSkills(String[] skills) {
            this.skills = skills;
        }

        public int getAvg_salary_in_rupees() {
            return avg_salary_in_rupees;
        }

        public void setAvg_salary_in_rupees(int avg_salary_in_rupees) {
            this.avg_salary_in_rupees = avg_salary_in_rupees;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
