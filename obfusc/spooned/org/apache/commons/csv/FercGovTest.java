package org.apache.commons.csv;


public class FercGovTest {
    private enum ContractColumnNames {
contract_id, seller_company_name, customer_company_name, customer_duns_number, contract_affiliate, FERC_tariff_reference, contract_service_agreement_id, contract_execution_date, contract_commencement_date, contract_termination_date, actual_termination_date, extension_provision_description, class_name, term_name, increment_name, increment_peaking_name, product_type_name, product_name, quantity, units_for_contract, rate, rate_minimum, rate_maximum, rate_description, units_for_rate, point_of_receipt_control_area, point_of_receipt_specific_location, point_of_delivery_control_area, point_of_delivery_specific_location, begin_date, end_date, time_zone;    }

    private static final java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");

    @org.junit.Test
    public void testContractFile() throws java.io.IOException {
        final java.net.URL contractData = java.lang.ClassLoader.getSystemClassLoader().getResource("ferc.gov/contract.txt");
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(contractData, US_ASCII, org.apache.commons.csv.CSVFormat.DEFAULT.c());
        try {
            final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
            org.apache.commons.csv.CSVRecord record = records.get(0);
            org.junit.Assert.assertEquals(22, records.size());
            org.junit.Assert.assertEquals("C71", record.a(ContractColumnNames.contract_id));
            org.junit.Assert.assertEquals("The Electric Company", record.a(ContractColumnNames.seller_company_name));
            org.junit.Assert.assertEquals("ES", record.a(ContractColumnNames.time_zone));
            record = records.get(((records.size()) - 1));
            org.junit.Assert.assertEquals("C78", record.a(ContractColumnNames.contract_id));
            org.junit.Assert.assertEquals("The Electric Company", record.a(ContractColumnNames.seller_company_name));
            org.junit.Assert.assertEquals("EP", record.a(ContractColumnNames.time_zone));
        } finally {
            parser.close();
        }
    }

    @org.junit.Test
    public void testTransactionFile() throws java.io.IOException {
        final java.net.URL transactionData = java.lang.ClassLoader.getSystemClassLoader().getResource("ferc.gov/transaction.txt");
        final org.apache.commons.csv.CSVParser parser = org.apache.commons.csv.CSVParser.parse(transactionData, US_ASCII, org.apache.commons.csv.CSVFormat.DEFAULT.c());
        try {
            final java.util.List<org.apache.commons.csv.CSVRecord> records = parser.b();
            org.junit.Assert.assertEquals(24, records.size());
            org.apache.commons.csv.CSVRecord record = records.get(0);
            org.junit.Assert.assertEquals("T1", record.c("transaction_unique_identifier"));
            org.junit.Assert.assertEquals("The Electric Company", record.c("seller_company_name"));
            org.junit.Assert.assertEquals("880386", record.c("transaction_charge"));
            record = records.get(((records.size()) - 1));
            org.junit.Assert.assertEquals("T15", record.c("transaction_unique_identifier"));
            org.junit.Assert.assertEquals("The Electric Company", record.c("seller_company_name"));
            org.junit.Assert.assertEquals("1800", record.c("transaction_charge"));
        } finally {
            parser.close();
        }
    }
}

