'use strict';
module.exports = (sequelize, DataTypes) => {
  const Reviews = sequelize.define('Reviews', {
    first_name: DataTypes.STRING,
    last_name: DataTypes.STRING,
    email: DataTypes.STRING,
    review_text: DataTypes.STRING
  }, {});
  Reviews.associate = function(models) {
    // associations can be defined here
  };
  return Reviews;
};
