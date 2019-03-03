/* SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO"; */
/* SET AUTOCOMMIT = 0; */
/* START TRANSACTION; */
/* SET time_zone = "+00:00"; */

-- --------------------------------------------------------

--
-- Table structure for table `category` generated from model 'category'
--

CREATE TABLE IF NOT EXISTS `category` (
  `domainId` ENUM('1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13') NOT NULL COMMENT 'Integer value for the Amazon locale you want to access. (1-com, 2-co.uk, 3-de, 4-fr, 5-co.jp, 6-ca, 7-cn, 8-it, 9-es, 10-in, 11-com.mx, 12-com.br, 13-com.au)',
  `catId` INT NOT NULL COMMENT 'The category node id used by Amazon. Represents the identifier of the category. Also part of the Product object’s categories and rootCategory fields. Always a positive Long value. Note - The id 9223372036854775807 (max signed long value) denotes a blank category with the name “?”. We use this in cases where a product is listed in no or non-existent categories.',
  `name` TEXT NOT NULL COMMENT 'The name of the category.',
  `children` JSON NOT NULL COMMENT 'List of all sub categories. null or [] (empty array) if the category has no sub categories.',
  `parent` INT NOT NULL COMMENT 'The parent category’s Id. Always a positive Long value. If it is 0 the category is a root category and has no parent category.',
  `highestRank` INT NOT NULL COMMENT 'The highest (root category) sales rank we have observed of a product that is listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.',
  `productCount` INT NOT NULL COMMENT 'Number of products that are listed in this category. Note- Estimate, as the value is from the Keepa product database and not retrieved from Amazon.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

