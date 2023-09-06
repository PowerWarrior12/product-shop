set enable_seqscan = false;

CREATE INDEX ON product(brand_name, category_name, producer_name);
CREATE INDEX ON product(brand_name, producer_name);
CREATE INDEX ON product(producer_name);