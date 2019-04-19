const express = require('express');
const router = express.Router();

router.get('/create-page', function(req, res) {
   res.render('../views/partials/create.ejs');
});

module.exports = router;
