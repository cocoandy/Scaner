package com.juke.scaner.bean;

import java.util.List;

/**
 * Created by Gavin
 * 2018/10/8
 */
public class CinemaInfo {

    /**
     * code : 0.0
     * message : 请求成功
     * content : {"cinemas":[{"id":"1","title":"深圳聚星国际影城","phone":"0755-28313188 ","address":"深圳市龙岗区李朗国际珠宝园C1栋3楼","distance":"-1"},{"id":"6","title":"中影泰得影城龙岗店","phone":"0755-84822350","address":"广东省深圳市龙岗区龙城街道中心城欧景花园3期10号楼底下二层商铺","distance":"-1"},{"id":"7","title":"Vista测试影院","phone":"021-60287188","address":"广东省深圳市龙华区","distance":"-1"}]}
     */

    private double code;
    private String message;
    private ContentBean content;

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        private List<CinemasBean> cinemas;

        public List<CinemasBean> getCinemas() {
            return cinemas;
        }

        public void setCinemas(List<CinemasBean> cinemas) {
            this.cinemas = cinemas;
        }

        public static class CinemasBean {
            /**
             * id : 1
             * title : 深圳聚星国际影城
             * phone : 0755-28313188
             * address : 深圳市龙岗区李朗国际珠宝园C1栋3楼
             * distance : -1
             */

            private String id;
            private String title;
            private String phone;
            private String address;
            private String distance;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }
        }
    }
}
