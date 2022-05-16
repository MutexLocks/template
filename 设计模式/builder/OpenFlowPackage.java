public final class OpenFlowPackage {
    private OpenFlowVersionEnum version;
    private OpenFlowTypeEnum type;
    private Integer length;
    private Integer transactionId;

    OpenFlowPackage(final OpenFlowVersionEnum version, final OpenFlowTypeEnum type, final Integer length, final Integer transactionId) {
        this.version = version;
        this.type = type;
        this.length = length;
        this.transactionId = transactionId;
    }

    public static OpenFlowPackage.OpenFlowPackageBuilder builder() {
        return new OpenFlowPackage.OpenFlowPackageBuilder();
    }

    public OpenFlowVersionEnum getVersion() {
        return this.version;
    }

    public OpenFlowTypeEnum getType() {
        return this.type;
    }

    public Integer getLength() {
        return this.length;
    }

    public Integer getTransactionId() {
        return this.transactionId;
    }

    public static class OpenFlowPackageBuilder {
        private OpenFlowVersionEnum version;
        private OpenFlowTypeEnum type;
        private Integer length;
        private Integer transactionId;

        OpenFlowPackageBuilder() {
        }

        public OpenFlowPackage.OpenFlowPackageBuilder version(final OpenFlowVersionEnum version) {
            this.version = version;
            return this;
        }

        public OpenFlowPackage.OpenFlowPackageBuilder type(final OpenFlowTypeEnum type) {
            this.type = type;
            return this;
        }

        public OpenFlowPackage.OpenFlowPackageBuilder length(final Integer length) {
            this.length = length;
            return this;
        }

        public OpenFlowPackage.OpenFlowPackageBuilder transactionId(final Integer transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public OpenFlowPackage build() {
            return new OpenFlowPackage(this.version, this.type, this.length, this.transactionId);
        }

        public String toString() {
            return "OpenFlowPackage.OpenFlowPackageBuilder(version=" + this.version + ", type=" + this.type + ", length=" + this.length + ", transactionId=" + this.transactionId + ")";
        }
    }
}
